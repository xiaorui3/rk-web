package 时间;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class main7 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sim=new SimpleDateFormat("yyyy年MM月dd日");
        String day1="2000年01月01日";String day2="2020年10月01日";
        Date p1=sim.parse(day1);
        Date p2=sim.parse(day2);
        List list=new ArrayList(findDates(p1,p2));
        int sum=0;
        for(int i=0;i<list.size();i=i+2){
            Object s=list.get(i);
            sum=sum+1;
            String s1=s.toString();
            String s11= String.valueOf(s1.charAt(0));
            String s22= String.valueOf(s1.charAt(8));
            String s33=String.valueOf(s1.charAt(9));
              if(s11.equals("M")||(s22.equals("0") && s33.equals("1"))){
                  sum=sum+1;
              }
        }
        System.out.println(list);
        System.out.println(sum);
    }
    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List lDate = new ArrayList();
        lDate.add(dBegin);
        lDate.add("\n");
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
            lDate.add("\n");
        }
        return lDate;
    }
}
