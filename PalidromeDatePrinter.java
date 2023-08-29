import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        for (int year = fromYear; year <= toYear; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= 31; day++) {
                    if (isValidDate(day, month, year) && isDatePalindrome(day, month, year)) {
                        System.out.println(year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day));
                    }
                }
            }
        }
    }

    public static boolean isValidDate(int day, int month, int year) {
        LocalDate date;
        try {
            date = LocalDate.of(year, month, day);
        } catch (Exception e) {
            return false;
        }
        return date != null && date.getDayOfMonth() == day
                && date.getMonthValue() == month && date.getYear() == year;
    }

    public static boolean isDatePalindrome(int day, int month, int year) {
        String dateString = String.format("%04d%02d%02d", year, month, day);
        String reverseString = new StringBuilder(dateString).reverse().toString();
        return dateString.equals(reverseString);
    }
}