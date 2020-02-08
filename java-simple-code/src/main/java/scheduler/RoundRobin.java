package scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RoundRobin {
    private static Deque<Process> processQueue = new ArrayDeque<>();
    private static List<Deque<Process>> cpuQueues = new ArrayList<>();

    public static void run(int numberOfCPU, List<Process> processes, long quantum) {
        for (int i = 0; i < numberOfCPU; i++) {
            cpuQueues.add(new ArrayDeque<>());
        }

        processQueue.addAll(processes);

        assert processQueue.peek() != null;
        Long currentTime = processQueue.peek().getArriveTime();
        Long scheduleStartTime = currentTime;
        int cpuOrder = 0;

        while (true) {
            boolean done = true;

            /* Round Robin 스케줄러 종료 조건
             *  모든 큐가 비어있는 경우 종료함   */
            if (!processQueue.isEmpty()) {
                done = false;
            }

            for (Deque<Process> cpuQueue : cpuQueues) {
                if (!cpuQueue.isEmpty()) {
                    done = false;
                    break;
                }
            }
            if (done) break;

            /*
            현재 시간에 도착하는 프로세스가 있는지 확인하고 이를 CPU 큐에 삽입
            - 해당 Process 객체의 CPU 종료 시간 계산
                - 만약 quantum 보다 처리시간이 많다면 이를 이 프로세스의 처리 시간을 다시 계산하여 process 큐에 넣는다.
             */

            Process currentProcess = processQueue.peek();
            if (!processQueue.isEmpty() && !currentProcess.isProcessed()
                    && (currentTime.equals(currentProcess.getArriveTime())
                    || (currentTime > currentProcess.getArriveTime() && currentProcess.getTotalBurstTime() > 0))
            ) {
                processQueue.poll();
                cpuQueues.get(cpuOrder).add(currentProcess);
                cpuOrder = (cpuOrder + 1) % numberOfCPU;
            }

            /*
            현재 시간에 CPU 큐에서 종료하는 프로세스 꺼내기
             */
            for (Deque<Process> cpuQueue : cpuQueues) {
                if (cpuQueue.isEmpty()) {
                    continue;
                }
                Process peekProcess = cpuQueue.peek();
                Long currentEndTime = peekProcess.getCurrentEndTime();
                if (currentTime.equals(currentEndTime)) {
                    peekProcess.setProcessed(false);
                    cpuQueue.poll();
                }
            }

            /*
            CPU 큐에 있는 프로세스의 시작
            */
            for (Deque<Process> cpuQueue : cpuQueues) {
                if (cpuQueue.isEmpty()) {
                    continue;
                }
                Process peekProcess = cpuQueue.peek();
                if (!peekProcess.isProcessed()) {
                    if (peekProcess.getCurrentStartTime() > 0) {
                        peekProcess.calculateTotalWaitingTime(currentTime - peekProcess.getCurrentEndTime());
                    } else {
                        peekProcess.calculateTotalWaitingTime(currentTime - peekProcess.getArriveTime());
                    }
                    peekProcess.setCurrentStartTime(currentTime);
                    peekProcess.setProcessed(true);

                    Long currentProcessBurstTime = peekProcess.getTotalBurstTime();
                    if (currentProcessBurstTime <= quantum) {
                        peekProcess.setCurrentEndTime(currentTime + currentProcessBurstTime);
                        peekProcess.calculateRemainingBurstTime(currentProcessBurstTime);
                    } else {
                        peekProcess.setCurrentEndTime(currentTime + quantum);
                        peekProcess.calculateRemainingBurstTime(quantum);
                        processQueue.add(peekProcess);
                    }
                }
            }

            // 현재 시간 재 설정
            Long nextTime;
            if (!processQueue.isEmpty()) {
                nextTime = processQueue.peek().getArriveTime();
            } else {
                nextTime = Long.MAX_VALUE;
            }
            for (Deque<Process> cpuQueue : cpuQueues) {
                if (!cpuQueue.isEmpty()) {
                    Long endTime = cpuQueue.peek().getCurrentEndTime();
                    nextTime = nextTime < endTime ? nextTime : endTime;
                }
            }

            if (nextTime.equals(Long.MAX_VALUE)) {
                break;
            } else {
                currentTime = nextTime;
            }
        }

        System.out.println(scheduleStartTime);
        System.out.println(currentTime);
        System.out.println(currentTime - scheduleStartTime);
    }
}
