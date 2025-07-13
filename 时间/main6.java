package 时间;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main6 {
    public static void main(String[] args) {
        Scanner lu=new Scanner(System.in);
        String date=lu.next();
        int []ri=new int[3];
        String zhengze="\\d*-";
        Date d=new Date(0L);
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        Calendar c=Calendar.getInstance();
        Pattern p=Pattern.compile(zhengze);
        Matcher matcher = p.matcher(date);
        c.setTime(d);
        for(int i=0;matcher.find();i++){
            ri[i]= Integer.parseInt(matcher.group());
        }
        c.set(1,ri[0]);
        c.set(2,ri[1]);
        c.set(5,ri[2]-2);
        System.out.println(c.get(1)+"-"+(c.get(2))+"-"+(c.get(5)-2));

    }
}
