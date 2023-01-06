package w11;

import java.text.SimpleDateFormat;
import java.util.*;

public class main5 {
    static Scanner lu=new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<student> stu=new ArrayList<>();
        int n=lu.nextInt();
        while(n!=0){
            n--;
            student stu1=new student();
            stu1.setName(lu.next());
            stu1.setBirthday_year(lu.nextInt());
            stu1.setBirthday_month(lu.nextInt());
            stu1.setBirthday_day(lu.nextInt());
            stu1.setSerial_No(n);
            stu.add(stu1);
        }
        long kai = System.currentTimeMillis();
        //shijian();
        for(int i=0;i<stu.size();i++){
            for(int j=0;j< stu.size();j++) {
                if (stu.get(j).getBirthday_year() < stu.get(i).getBirthday_year()) {
                    continue;
                }
                else if (stu.get(j).getBirthday_year() == stu.get(i).getBirthday_year()) {
                    if (stu.get(j).getBirthday_month() < stu.get(i).getBirthday_month()) {
                        continue;
                    }
                    else if (stu.get(j).getBirthday_month() == stu.get(i).getBirthday_month()) {
                        if (stu.get(j).getBirthday_day() < stu.get(i).getBirthday_day()) {
                            continue;
                        }
                        else if (stu.get(j).getBirthday_day() == stu.get(i).getBirthday_day()) {
                            if(stu.get(j).getSerial_No()<stu.get(i).getSerial_No()){
                                Collections.swap(stu, j, i);
                            }
                        }
                        else {
                            Collections.swap(stu, j, i);
                        }
                    }
                    else {
                        Collections.swap(stu, j, i);
                    }
                }
                else {
                    Collections.swap(stu, j, i);
                }
            }
        }
        for(int i=0;i<stu.size();i++){
            System.out.println(stu.get(i).getName());
        }
        long jie= System.currentTimeMillis();
        //shijian();
        //System.out.println("程序运行时间:"+(jie-kai)+"ms");
    }
    public static void shijian(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));//定义时区，可以避免虚拟机时间与系统时间不一致的问题
        Date nowTime = new Date();
        SimpleDateFormat matter = new SimpleDateFormat(
                "现在时间:yyyy年MM月dd日E HH时mm分ss秒");
        System.out.println(matter.format(nowTime));//SimpleDateFormat方式，完整输出现在时间

    }
}
