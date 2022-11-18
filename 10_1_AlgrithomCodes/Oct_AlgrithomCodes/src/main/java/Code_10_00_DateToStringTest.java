import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Code_10_00_DateToStringTest {
    public static void main(String[] args) {
        // String -> Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = "2022-10-15 16:31:30";
        try {
            Date date1 = sdf.parse(dateStr1);
            System.out.println("date1 = " + date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //Date -> String
        Date date2 = new Date();
        System.out.println("date2 = " + date2);
        String dateStr2 = sdf.format(date2);
        System.out.println("dateStr2 = " + dateStr2);

        // String -> java.time.LocalDateTime
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeStr1 = "2022-10-15 16:42:30";
        LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeStr1, dtf);
        // java.time.LocalDateTime -> String
        LocalDateTime localDateTime1 = LocalDateTime.now();
        String localDateTimeStr2 = dtf.format(localDateTime1);
    }
}
