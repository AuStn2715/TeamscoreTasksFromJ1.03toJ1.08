package J103;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MicroTask2 {
    public static String timezoneComparator(String stringDateTime, String stringTimezone1, String stringTimezone2) {
        var DEFAULT_TIME_ZONE = ZoneId.of("UTC-9");
        LocalDateTime dateTime = ZonedDateTime.parse(stringDateTime).toLocalDateTime();
        ZoneId timezone1 = ZoneId.of(stringTimezone1);
        ZoneId timezone2 = ZoneId.of(stringTimezone2);
        LocalDateTime dateTime1 = dateTime.atZone(timezone1).withZoneSameInstant(DEFAULT_TIME_ZONE).toLocalDateTime();
        LocalDateTime dateTime2 = dateTime.atZone(timezone2).withZoneSameInstant(DEFAULT_TIME_ZONE).toLocalDateTime();

        int difference = 0;

        difference = dateTime1.getYear() - dateTime2.getYear();
        if (difference != 0) {
            return "YEAR";
        }
        difference = dateTime1.getMonthValue() - dateTime2.getMonthValue();
        if (difference != 0) {
            return "MONTH";
        }
        difference = dateTime1.getDayOfMonth() - dateTime2.getDayOfMonth();
        if (difference != 0) {
            return "DAY";
        }
        difference = dateTime1.getHour() - dateTime2.getHour();
        if (difference != 0) {
            return "HOUR";
        }
        difference = dateTime1.getMinute() - dateTime2.getMinute();
        if (difference != 0) {
            return "MINUTE";
        }
        return "0";
    }
}
