package J104;

import java.time.LocalDate;

public class DatesRange {
    public static String[] datesBetweenArray(String strStartDate, String strEndDate) {
        LocalDate startDate = LocalDate.parse(strStartDate);
        LocalDate endDate = LocalDate.parse(strEndDate);
        int daysCount = endDate.getDayOfYear() - startDate.getDayOfYear() + 1;
        if (daysCount < 1) return new String[0];

        String[] dates = new String[daysCount];
        for (int i = 0; i < daysCount; i++) {
            dates[i] = (startDate.plusDays(i)).toString();
        }
        return dates;
    }
}
