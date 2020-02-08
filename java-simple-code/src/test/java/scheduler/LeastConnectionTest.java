package scheduler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LeastConnectionTest {

    @Test
    @DisplayName("CPU(서버)가 2개일 때 Least Connection 으로 각 프로세스를 처리하는 경우")
    void cpu_2() {
        List<String> logs = Arrays.asList(
                "12:00:00.100 0.400",
                "12:00:00.200 0.500",
                "12:00:00.300 0.100",
                "12:00:00.400 0.600",
                "12:00:00.500 0.200",
                "12:00:00.600 0.400");

        int size = logs.size();
        List<String> arriveTimeLogs = new ArrayList<>();
        List<String> burstTimeLogs = new ArrayList<>();
        LogTimeStringUtils.split(logs, arriveTimeLogs, burstTimeLogs);

        List<Process> processes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Process process = new Process((long) i,
                    LogTimeStringUtils.convertArriveTime(arriveTimeLogs.get(i)).getTime(),
                    LogTimeStringUtils.convertBurstTime(burstTimeLogs.get(i)).getTime());
            processes.add(process);
        }

        int numberOfCPU = 2;

        LeastConnection.run(numberOfCPU, processes);
    }
}
