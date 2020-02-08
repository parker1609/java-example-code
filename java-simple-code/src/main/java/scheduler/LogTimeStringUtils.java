package scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class LogTimeStringUtils {
    private static final String DELIMITER = " ";

    public static void split(List<String> logs, List<String> arriveTimes, List<String> burstTimes) {
        for (String log : logs) {
            String[] splitTime = log.split(DELIMITER);
            arriveTimes.add(splitTime[0]);
            burstTimes.add(splitTime[1]);
        }
    }

    public static Date convertArriveTime(String arriveTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("KST"));

        try {
            return sdf.parse(arriveTime);
        } catch (ParseException e) {
            throw new TimeConvertException(e);
        }
    }

    public static Date convertBurstTime(String burstTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("s.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("KST"));

        try {
            return sdf.parse(burstTime);
        } catch (ParseException e) {
            throw new TimeConvertException(e);
        }
    }
}
