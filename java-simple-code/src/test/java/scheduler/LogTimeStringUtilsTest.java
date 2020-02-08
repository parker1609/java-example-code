package scheduler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LogTimeStringUtilsTest {

    @Test
    @DisplayName("Log 는 'HH:MM:SS.SSS S.SSS'형태이며, '도착시각 처리시각'이다. 도착시각과 처리시각을 분리한다.")
    void split_arrive_time_and_burst_time() {
        List<String> logs = Arrays.asList(
                "12:00:00.100 0.400",
                "12:00:00.200 0.500",
                "12:00:00.300 0.100",
                "12:00:00.400 0.600",
                "12:00:00.500 0.200",
                "12:00:00.600 0.400");
        List<String> arriveTimes = new ArrayList<>();
        List<String> burstTimes = new ArrayList<>();

        LogTimeStringUtils.split(logs, arriveTimes, burstTimes);

        assertThat(arriveTimes.get(0)).isEqualTo("12:00:00.100");
        assertThat(arriveTimes.get(1)).isEqualTo("12:00:00.200");
        assertThat(arriveTimes.get(2)).isEqualTo("12:00:00.300");
        assertThat(arriveTimes.get(3)).isEqualTo("12:00:00.400");
        assertThat(arriveTimes.get(4)).isEqualTo("12:00:00.500");
        assertThat(arriveTimes.get(5)).isEqualTo("12:00:00.600");

        assertThat(burstTimes.get(0)).isEqualTo("0.400");
        assertThat(burstTimes.get(1)).isEqualTo("0.500");
        assertThat(burstTimes.get(2)).isEqualTo("0.100");
        assertThat(burstTimes.get(3)).isEqualTo("0.600");
        assertThat(burstTimes.get(4)).isEqualTo("0.200");
        assertThat(burstTimes.get(5)).isEqualTo("0.400");
    }

    @Test
    @DisplayName("문자열 도착 시간을 Date 자료형으로 변경한다.")
    void convert_string_arrive_time_to_date() {
        String arriveTime = "12:00:00.100";
        Date time = LogTimeStringUtils.convertArriveTime(arriveTime);
        System.out.println(time);
        System.out.println(time.getTime());

        assertThat(time).isNotNull();
    }

    @Test
    @DisplayName("문자열 처리 시간을 Date 자료형으로 변경한다.")
    void convert_string_burst_time_to_date() {
        String burstTime = "0.400";
        Date time = LogTimeStringUtils.convertBurstTime(burstTime);
        System.out.println(time);
        System.out.println(time.getTime());

        assertThat(time).isNotNull();
    }
}
