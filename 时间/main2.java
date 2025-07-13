package 时间;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main2 {
    public static void main(String[] args) throws ParseException {
        String str1="2023年11月11日 0:0:0";
        String str2="2023年11月11日 0:10:0";
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date parse = sdf1.parse(str1);
        Date parse1 = sdf1.parse(str2);
        //System.out.println(parse1);
        //long str_str=parse1.getTime()-parse.getTime();
        String xiaojia="2023年11月11日 0:01:0";
        String xiaopi="2023年11月11日 0:11:0";
        final Date parse2 = sdf1.parse(xiaojia);
        final Date parse3 = sdf1.parse(xiaopi);
        if(parse2.getTime()<=parse1.getTime()){
            System.out.println("yes");
        }
        else{
            System.out.println("on");
        }
        if(parse3.getTime()<=parse1.getTime()){
            System.out.println("yes");
        }
        else {
            System.out.println("on");
        }
    }
}
