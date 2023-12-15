import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static J103.MicroTask3.getWeekendCount;
public class getWeekendCountTest {
    @Test
    void test() {
        assertEquals(0, getWeekendCount("2023-11-01","2023-11-01"));
        assertEquals(0, getWeekendCount("2023-05-01","2023-05-03"));
        assertEquals(1, getWeekendCount("2023-01-01","2023-01-01"));
        assertEquals(1, getWeekendCount("2023-05-01","2023-05-06"));
        assertEquals(1, getWeekendCount("2023-05-07","2023-05-10"));
        assertEquals(2, getWeekendCount("2023-05-01","2023-05-07"));
        assertEquals(2, getWeekendCount("2023-05-01","2023-05-08"));
        assertEquals(2, getWeekendCount("2023-05-06","2023-05-07"));
        assertEquals(2, getWeekendCount("2023-05-06","2023-05-09"));
        assertEquals(4, getWeekendCount("2023-05-01","2023-05-16"));
        assertEquals(105, getWeekendCount("2023-01-01","2023-12-31"));
    }
}
