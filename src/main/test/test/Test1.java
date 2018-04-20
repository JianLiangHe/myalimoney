package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test1 {

    public static void main(String[] args) {
        /*Date date = new Date(new Date().getTime() - 24 * 60 * 60 * 1000);
        System.out.println(date.getTime());*/

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String dateStr = sdf.format(cal.getTime());
        System.out.println(dateStr);
        try {
            Date date = sdf.parse(dateStr);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
