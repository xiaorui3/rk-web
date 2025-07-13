package 时间;

import java.util.Calendar;
import java.util.Date;

public class main5 {
    public static void main(String[] args) {
        Calendar c=Calendar.getInstance();
        //System.out.println(c);
        Date d=new Date();
        c.setTime(d);
        System.out.println(c.get(1)+","+(c.get(2)+1)+","+c.get(5)+","+week(c.get(7)));
        //System.out.println(c);
    }
    public static String week(int n){
        String[] a={"","星期日","星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
        return a[n];
    }
}
