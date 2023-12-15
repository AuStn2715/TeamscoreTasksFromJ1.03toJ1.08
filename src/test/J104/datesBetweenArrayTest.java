package J104;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;;
import java.util.Arrays;

import static J104.DatesRange.datesBetweenArray;

public class datesBetweenArrayTest {
    @Test
    void test() {
        var expected1 = new String[]{};
        var expected2 = new String[]{"2023-02-28"};
        var expected3 = new String[]{"2020-05-28", "2020-05-29", "2020-05-30", "2020-05-31",
                "2020-06-01", "2020-06-02"};
        Assertions.assertTrue(Arrays.deepEquals(expected1, datesBetweenArray("2023-11-12","2023-11-11")));
        Assertions.assertTrue(Arrays.deepEquals(expected2, datesBetweenArray("2023-02-28","2023-02-28")));
        Assertions.assertTrue(Arrays.deepEquals(expected3, datesBetweenArray("2020-05-28","2020-06-02")));
    }
}
