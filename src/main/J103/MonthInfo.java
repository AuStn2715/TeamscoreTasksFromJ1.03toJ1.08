package J103;
import java.time.LocalDate;

public class MonthInfo {
    LocalDate currentDate;
    public MonthInfo(LocalDate currentDate) {
        this.currentDate = currentDate;
    }
    public MonthInfo() {
        this(LocalDate.now());
    }

    public String getMonthName() {
        return translate(currentDate.getMonth().name());
    }
    public int getMonthNumber() {
        return currentDate.getMonthValue();
    }
    public String getFirstDayOfMonthAsDayOfWeek() {
        return translate(currentDate.withDayOfMonth(1).getDayOfWeek().toString());
    }
    public String getLastDayOfMonthDate() {
        return  currentDate.withDayOfMonth(currentDate.lengthOfMonth()).toString();
    }
    public int getNumberOfDaysInMonth() {
        return currentDate.lengthOfMonth();
    }
    public String getQuarter() {
        int q = (int)(Math.ceil((double)currentDate.getMonthValue()/3.0));
        return String.valueOf(currentDate.getYear()) + " Q" + q;
    }

    private String translate(String engText) {
        switch (engText) {
            case ("JANUARY"): return "январь";
            case ("FEBRUARY"): return "февраль";
            case ("MARCH"): return "март";
            case ("APRIL"): return "апрель";
            case ("MAY"): return "май";
            case ("JUNE"): return "июнь";
            case ("JULY"): return "июль";
            case ("AUGUST"): return "август";
            case ("SEPTEMBER"): return "сентябрь";
            case ("OCTOBER"): return "октябрь";
            case ("NOVEMBER"): return "ноябрь";
            case ("DECEMBER"): return "декабрь";

            case ("MONDAY"): return "пн";
            case ("TUESDAY"): return "вт";
            case ("WEDNESDAY"): return "ср";
            case ("THURSDAY"): return "чт";
            case ("FRIDAY"): return "пт";
            case ("SATURDAY"): return "сб";
            case ("SUNDAY"): return "вс";
        }
        return "не перевелось";
    }
}
