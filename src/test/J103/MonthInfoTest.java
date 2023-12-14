package J103;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

public class MonthInfoTest {

    @Test
    void test1() {
        MonthInfo date = new MonthInfo(LocalDate.of(2023, 11, 12));
        assertEquals("ноябрь", date.getMonthName());
        assertEquals(11, date.getMonthNumber());
        assertEquals("ср", date.getFirstDayOfMonthAsDayOfWeek());
        assertEquals("2023-11-30", date.getLastDayOfMonthDate());
        assertEquals(30, date.getNumberOfDaysInMonth());
        assertEquals("2023 Q4", date.getQuarter());
    }

    @Test
    void test2() {
        MonthInfo date = new MonthInfo(LocalDate.of(1900, 01, 01));
        assertEquals("январь", date.getMonthName());
        assertEquals(1, date.getMonthNumber());
        assertEquals("пн", date.getFirstDayOfMonthAsDayOfWeek());
        assertEquals("1900-01-31", date.getLastDayOfMonthDate());
        assertEquals(31, date.getNumberOfDaysInMonth());
        assertEquals("1900 Q1", date.getQuarter());
    }

    @Test
    void test3() {
        MonthInfo date = new MonthInfo(LocalDate.of(2020, 02, 12));
        assertEquals("февраль", date.getMonthName());
        assertEquals(2, date.getMonthNumber());
        assertEquals("сб", date.getFirstDayOfMonthAsDayOfWeek());
        assertEquals("2020-02-29", date.getLastDayOfMonthDate());
        assertEquals(29, date.getNumberOfDaysInMonth());
        assertEquals("2020 Q1", date.getQuarter());
    }

}
