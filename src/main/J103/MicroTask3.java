package J103;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class MicroTask3 {
    public static int getWeekendCount(String strStartDate, String strEndDate) {
        LocalDate startDate = LocalDate.parse(strStartDate);
        LocalDate endDate = LocalDate.parse(strEndDate);

        int daysBetween = endDate.getDayOfYear() - startDate.getDayOfYear();
        int weeksBetween = daysBetween / 7;
        int weekendCount = weeksBetween * 2;

        int start = dayOfWeekToNumber(startDate.getDayOfWeek().toString());
        int end = dayOfWeekToNumber(endDate.getDayOfWeek().toString());
        weekendCount = weekendCount + getWeekendCountInLastWeek(start,end);
        return weekendCount;
    }

    // матрица стартХконец, оставшиеся дни, если временной промежуток < недели
    /* пн вт ср чт пт сб вс
    пн 0  1  2  3  4  5  6
    вт 6  0  1  2  3  4  5
    ср 5  6  0  1  2  3  4
    чт 4  5  6  0  1  2  3
    пт 3  4  5  6  0  1  2
    сб 2  3  4  5  6  0  1
    вс 1  2  3  4  5  6  0 */
    // матрица стартХконец, количество выходных
    /* пн вт ср чт пт сб вс
    пн 0  0  0  0  0  1  2
    вт 2  0  0  0  0  1  2
    ср 2  2  0  0  0  1  2
    чт 2  2  2  0  0  1  2
    пт 2  2  2  2  0  1  2
    сб 2  2  2  2  2  1  2
    вс 1  1  1  1  1  2  1 */

    private static int getWeekendCountInLastWeek(int start, int end) {
        if (start == 7) {
            if (end == 6) return 2;
            else return 1;
        }
        if (end == 6) return 1;
        if (end == 7) return 2;

        if (start > end) return 2;
        return 0;
    }

    private static int dayOfWeekToNumber (String day) {
        switch (day) {
            case ("MONDAY"): return 1;
            case ("TUESDAY"): return 2;
            case ("WEDNESDAY"): return 3;
            case ("THURSDAY"): return 4;
            case ("FRIDAY"): return 5;
            case ("SATURDAY"): return 6;
            case ("SUNDAY"): return 7;
        }
        return -1;
    }

}
