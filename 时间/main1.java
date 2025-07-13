package 时间;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main1 {
    public static void main(String[] args) throws ParseException {
        extracted();

        extracted1();

        extracted2();
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EE");
        Date d2=new Date();
        final String f3 = sdf2.format(d2);
        System.out.println(f3);
        SimpleDateFormat sdf3=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d3=sdf3.parse(f3);
        System.out.println(d3.getTime());

    }

    private static void extracted() {
        SimpleDateFormat sdf=new SimpleDateFormat();
        Date d=new Date(0L);
        final String f = sdf.format(d);
        System.out.println(f);
    }

    private static void extracted1() {
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d1=new Date(0L);
        final String f2 = sdf1.format(d1);
        System.out.println(f2);
    }

    private static void extracted2() {
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EE");
        Date d2=new Date();
        final String f3 = sdf2.format(d2);
        System.out.println(f3);
    }
}
