package 算法;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 月份Date {
    public static void main(String[] args) {
        Date date =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        String format = sdf.format(date);
        long time = date.getTime();
        Calendar c=Calendar.getInstance();
        c.setTime(date);
    }
}
