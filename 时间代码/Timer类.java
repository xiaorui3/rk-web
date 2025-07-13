package java代码.时间代码;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class Timer类 {
       public static void main(String[] args) {
            Timer timer = new Timer();
            //创建时间对象，获取当前系统时间
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            //执行定时器任务
            timer.schedule(new TimerTask() {
            @Override
            public void run() {
             System.out.print(" 当前时间:" + format.format(new java.util.Date()));
                             }
         }, 0, 1000);      //0延迟，每隔1秒（1000毫秒）执行一次
     }
}
