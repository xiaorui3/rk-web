package java代码.随机数;

public class Ran {
    /**
     *
     表 1 Random 类的常用方法
     方法	说明
     boolean nextBoolean()	生成一个随机的 boolean 值，生成 true 和 false 的值概率相等
     double nextDouble()	生成一个随机的 double 值，数值介于 [0,1.0)，含 0 而不包含 1.0
     int nextlnt()	生成一个随机的 int 值，该值介于 int 的区间，也就是 -231~231-1。如果
     需要生成指定区间的 int 值，则需要进行一定的数学变换
     int nextlnt(int n)	生成一个随机的 int 值，该值介于 [0,n)，包含 0 而不包含 n。如果想生成
     指定区间的 int 值，也需要进行一定的数学变换
     void setSeed(long seed)	重新设置 Random 对象中的种子数。设置完种子数以后的 Random 对象
     和相同种子数使用 new 关键字创建出的 Random 对象相同
     long nextLong()	返回一个随机长整型数字
     boolean nextBoolean()	返回一个随机布尔型值
     float nextFloat()	返回一个随机浮点型数字
     double nextDouble()	返回一个随机双精度值
     例 1
     下面编写一个 Java 程序，演示如何使用 Random 类提供的方法来生成随机数。具体代码如下:
     import java.util.Random;
     public class Test06 {
     public static void main(String[] args) {
     Random r = new Random();
     double d1 = r.nextDouble(); // 生成[0,1.0]区间的小数
     double d2 = r.nextDouble() * 7; // 生成[0,7.0]区间的小数
     int i1 = r.nextInt(10); // 生成[0,10]区间的整数
     int i2 = r.nextInt(18) - 3; // 生成[-3,15)区间的整数
     long l1 = r.nextLong(); // 生成一个随机长整型值
     boolean b1 = r.nextBoolean(); // 生成一个随机布尔型值
     float f1 = r.nextFloat(); // 生成一个随机浮点型值
     System.out.println("生成的[0,1.0]区间的小数是：" + d1);
     System.out.println("生成的[0,7.0]区间的小数是：" + d2);
     System.out.println("生成的[0,10]区间的整数是：" + i1);
     System.out.println("生成的[-3,15]区间的整数是：" + i2);
     System.out.println("生成一个随机长整型值：" + l1);
     System.out.println("生成一个随机布尔型值：" + b1);
     System.out.println("生成一个随机浮点型值：" + f1);
     System.out.print("下期七星彩开奖号码预测：");
     for (int i = 1; i < 8; i++) {
     int num = r.nextInt(9); // 生成[0,9]区间的整数
     System.out.print(num);
     }
     }
     }
     本实例每次运行时结果都不相同，这就实现了随机产生数据的功能。该程序的运行结果如下：
     生成的[0,1.0]区间的小数是：0.8773165855918825
     生成的[0,7.0]区间的小数是：6.407083074782282
     生成的[0,10]区间的整数是：5
     生成的[-3,15]区间的整数是：4
     生成一个随机长整型值：-8462847591661221914
     生成一个随机布尔型值：false
     生成一个随机浮点型值：0.6397003
     下期七星彩开奖号码预测：0227168
     */
}
