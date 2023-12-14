package J103;

import org.junit.jupiter.api.Test;

import static J103.MicroTask2.timezoneComparator;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TimezoneComparatorTest {
    @Test
    void test() {
        assertEquals("0", timezoneComparator("2023-11-12T00:00:00Z", "UTC+00",
                "UTC+00"));
        assertEquals("HOUR", timezoneComparator("2020-06-01T14:25:16Z", "UTC+01",
                "UTC+02"));
        assertEquals("HOUR", timezoneComparator("2020-06-01T14:25:16Z", "UTC+05",
                "UTC+01"));
        assertEquals("DAY", timezoneComparator("2023-05-10T23:00:00Z", "UTC-03",
                "UTC+04")); // досюда работает с utc+0
        assertEquals("MONTH", timezoneComparator("2024-10-01T04:59:59Z", "UTC-08",
                "UTC-04")); // тут -9
        assertEquals("YEAR", timezoneComparator("2010-12-31T20:15:00Z",
                "Europe/Moscow", "Asia/Vladivostok"));
    }

}
