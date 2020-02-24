package scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ScheduleProblem {
    private static class Process {
        Long requestTime;
        Long burstTime;
        Long endTime;

        public Process(Long requestTime, Long burstTime) {
            this.requestTime = requestTime;
            this.burstTime = burstTime;
            this.endTime = 0L;
        }
    }

    public int[] solution(int numServer, String[] logs) {
        int[] answer = new int[2];

        SimpleDateFormat requestTimeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        SimpleDateFormat burstTimeFormat = new SimpleDateFormat("s.SSS");
        requestTimeFormat.setTimeZone(TimeZone.getTimeZone("KST"));
        burstTimeFormat.setTimeZone(TimeZone.getTimeZone("KST"));

        List<Process> processQueue = new ArrayList<>();

        for (String log : logs) {
            String[] parseLog = log.split(" ");
            try {
                Date requestTime = requestTimeFormat.parse(parseLog[0]);
                Date burstTime = burstTimeFormat.parse(parseLog[1]);
                Process process = new Process(requestTime.getTime(), burstTime.getTime());
                processQueue.add(process);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Long resultRoundRobin = scheduleRoundRobin(numServer, processQueue);
        Long resultLeastConnection = scheduleLeastConnection(numServer, processQueue);

        System.out.println(resultRoundRobin);
        System.out.println(resultLeastConnection);
        if (resultRoundRobin > resultLeastConnection) {
            answer[0] = 2;
            answer[1] = (int)(resultRoundRobin - resultLeastConnection);
        } else if (resultRoundRobin < resultLeastConnection) {
            answer[0] = 1;
            answer[1] = (int)(resultLeastConnection - resultRoundRobin);
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }

    private Long scheduleRoundRobin(int numServer, List<Process> processes) {
        List<Deque<Process>> serverQueues = new ArrayList<>();
        for (int i = 0; i < numServer; i++) {
            serverQueues.add(new ArrayDeque<>());
        }
        Deque<Process> processQueue = new ArrayDeque<>();
        for (Process process : processes) {
            processQueue.add(new Process(process.requestTime, process.burstTime));
        }

        if (processQueue.isEmpty()) {
            return 0L;
        }

        int serverOrder = 0;
        long currentTime = processQueue.peek().requestTime;
        long scheduleStartTime = currentTime;

        while (true) {
            // 서버 큐에 삽입
            if (!processQueue.isEmpty()) {
                Process currentProcess = processQueue.poll();
                if (currentTime == currentProcess.requestTime) {
                    serverQueues.get(serverOrder).add(currentProcess);
                    serverOrder = (serverOrder + 1) % numServer;

                }
            }

            // 종료 프로세스 처리
            for (Deque<Process> serverQueue : serverQueues) {
                if (serverQueue.isEmpty()) continue;
                if (currentTime == serverQueue.peek().endTime) {
                    serverQueue.poll();
                }
            }

            // 프로세스 시작
            for (Deque<Process> serverQueue : serverQueues) {
                if (serverQueue.isEmpty()) continue;
                if (serverQueue.peek().endTime == 0L) {
                    serverQueue.peek().endTime = currentTime + serverQueue.peek().burstTime;
                }
            }

            // 다음 시간 및 탈출 조건
            long nextTime;
            if (!processQueue.isEmpty()) {
                nextTime = processQueue.peek().requestTime;
            } else {
                nextTime = Long.MAX_VALUE;
            }

            for (Deque<Process> serverQueue : serverQueues) {
                if (serverQueue.isEmpty()) continue;
                nextTime = Math.min(nextTime, serverQueue.peek().endTime);
            }

            if (nextTime == Long.MAX_VALUE) {
                break;
            } else {
                currentTime = nextTime;
            }
        }

        return currentTime - scheduleStartTime;
    }

    private Long scheduleLeastConnection(int numServer, List<Process> processes) {
        List<Deque<Process>> serverQueues = new ArrayList<>();
        for (int i = 0; i < numServer; i++) {
            serverQueues.add(new ArrayDeque<>());
        }
        Deque<Process> processQueue = new ArrayDeque<>();
        for (Process process : processes) {
            processQueue.add(new Process(process.requestTime, process.burstTime));
        }

        if (processQueue.isEmpty()) {
            return 0L;
        }

        int serverOrder = 0;
        long currentTime = processQueue.peek().requestTime;
        long scheduleStartTime = currentTime;

        while (true) {
            // 서버 큐에 삽입
            if (!processQueue.isEmpty()) {
                Process currentProcess = processQueue.poll();
                int numProcess = Integer.MAX_VALUE;
                for (int i = 0; i < serverQueues.size(); i++) {
                    if (numProcess > serverQueues.get(i).size()) {
                        numProcess = serverQueues.get(i).size();
                        serverOrder = i;
                    }
                }
                if (currentTime == currentProcess.requestTime) {
                    serverQueues.get(serverOrder).add(currentProcess);
                }
            }

            // 종료 프로세스 처리
            for (Deque<Process> serverQueue : serverQueues) {
                if (serverQueue.isEmpty()) continue;
                if (currentTime == serverQueue.peek().endTime) {
                    serverQueue.poll();
                }
            }

            // 프로세스 시작
            for (Deque<Process> serverQueue : serverQueues) {
                if (serverQueue.isEmpty()) continue;
                if (serverQueue.peek().endTime == 0L) {
                    serverQueue.peek().endTime = currentTime + serverQueue.peek().burstTime;
                }
            }

            // 다음 시간 및 탈출 조건
            long nextTime;
            if (!processQueue.isEmpty()) {
                nextTime = processQueue.peek().requestTime;
            } else {
                nextTime = Long.MAX_VALUE;
            }

            for (Deque<Process> serverQueue : serverQueues) {
                if (serverQueue.isEmpty()) continue;
                nextTime = Math.min(nextTime, serverQueue.peek().endTime);
            }

            if (nextTime == Long.MAX_VALUE) {
                break;
            } else {
                currentTime = nextTime;
            }
        }

        return currentTime - scheduleStartTime;
    }
}
