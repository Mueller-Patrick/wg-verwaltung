package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Utility class used to format a date to a localized date string
 */
public class DateFormatter {
    public static String dateTimeSecondsToString(Date date) {
        String pattern = "dd.MM.yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern, Locale.GERMAN);

        return df.format(date);
    }

    public static String dateTimeMinutesToString(Date date) {
        String pattern = "dd.MM.yyyy HH:mm";
        DateFormat df = new SimpleDateFormat(pattern, Locale.GERMAN);

        return df.format(date);
    }

    public static String dateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd. MMMM yyyy", Locale.GERMAN);
        return formatter.format(date);
    }

    public static Date getCurrentDateTime() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
        Date currentDate = calendar.getTime();

        return currentDate;
    }
}
