package J103;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main (String[] args) {
        var stringDateTime = "2024-10-01T04:59:59Z";
        var stringTimezone1 = "UTC-08";
        var stringTimezone2 = "UTC-04";
        var defaultTimeZone = ZoneId.of("UTC-9");

        LocalDateTime dateTime = ZonedDateTime.parse(stringDateTime).toLocalDateTime();
        ZoneId timezone1 = ZoneId.of(stringTimezone1);
        ZoneId timezone2 = ZoneId.of(stringTimezone2);
        LocalDateTime dateTime1 = dateTime.atZone(timezone1).withZoneSameInstant(DEFAULT_TIME_ZONE).toLocalDateTime();
        LocalDateTime dateTime2 = dateTime.atZone(timezone2).withZoneSameInstant(DEFAULT_TIME_ZONE).toLocalDateTime();

        System.out.println(dateTime1.toString());
        System.out.println(dateTime2.toString());
    }
}
