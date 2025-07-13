package java代码.时间代码;

import java.util.Date;
import java.util.Scanner;
public class Date类 {
    /**
     * 1.构造方法:
     *     Date()：
     *     Date(long date)：指定的时间
     *     Date date1 = new Date();    // 调用无参数构造函数
     *     System.out.println(date1.toString());    // 输出：Wed May 18 21:24:40 CST 2016
     *     Date date2 = new Date(60000);    // 调用含有一个long类型参数的构造函数
     *     System.out.println(date2);    // 输出：Thu Jan 0108:01:00 CST 1970
     *     */


    /*详细看解释txt*/
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("请输入要做的事情：");
    String title = input.next();
    Date date1 = new Date(); // 获取当前日期
    System.out.println("[" + title + "] 这件事发生时间为：" + date1);
    try {
        Thread.sleep(60000);// 暂停 1 分钟
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    Date date2 = new Date();
    System.out.println("现在时间为：" + date2);
    if (date2.before(date1)) {
        System.out.println("你还有 " + (date2.getTime() - date1.getTime()) / 1000 + " 秒需要去完成【" + title + "】这件事！");
    } else {
        System.out.println("【" + title + "】事情已经过去了 " + (date2.getTime() - date1.getTime()) / 1000 + " 秒");
    }
}
}
