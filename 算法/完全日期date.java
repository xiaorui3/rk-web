package 算法;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class 完全日期date {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2001-1-1");
        System.out.println(date);
        Calendar cal=new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH,1);
        date=cal.getTime();
        System.out.println(date);
    }
}
