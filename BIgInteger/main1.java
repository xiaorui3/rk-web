package java代码.BIgInteger;

public class main1 {
    public static void main(String[] args) {
/**
 * BigInteger 对象的创建
 *         BigInteger 类在 java.math.BigInteger 包中，首先引用该包。
 *
 *             import java.math.BigInteger;
 *         BigInteger 对象的创建
 *
 *         BigInteger a = new BigInteger("123"); // 这里是字符串
 *         改变 BigInteger 的值
 *
 *         String str = "123";
 *         BigInteger a = BigInteger.valueOf(str);
 *
 *         int num = 456;
 *         BigInteger a = BigInteger.valueOf(num);
 *         基本常量
 *
 *         a = BigInteger.ONE // 1
 *         b = BigInteger.TEN // 10
 *         c = BigInteger.ZERO // 0
 *         BigInteger 的输入输出
 *         直接读入 BigInteger
 *
 *         Scanner in = new Scanner(System.in);
 *         while(in.hasNext()) //等同于!=EOF
 *         {
 *             BigInteger a;
 *             a = in.nextBigInteger();
 *             System.out.print(a.toString());
 *         }
 *         间接读入 BigInteger
 *
 *         Scanner in = new Scanner(System.in);
 *         while(in.hasNext()) //等同于!=EOF
 *         {
 *             String s = in.nextLine();
 *             BigInteger a = new BigInteger(s);
 *             System.out.print(a.toString());
 *         }
 *         BigInteger 直接输出
 *
 *         System.out.print(a);
 *         BigInteger 转化成十进制表示的 String
 *
 *         System.out.print(a.toString());
 *         BigInteger 转化成 p 进制表示的 String
 *
 *         int p = 2;
 *         System.out.print(a.toString(p)); // 输出a的二进制
 *         BigInteger 二进制下的长度
 *
 *         BigInteger n = new BigInteger("12");
 *         System.out.println(n.bitLength()); // 4
 *         BigInteger 的基本运算
 *         BigInteger 之间的比较
 *
 *         BigInteger a = new BigInteger("123");
 *         BigInteger b = new BigInteger("456");
 *
 *         System.out.println(a.equals(b)); // a == b 时为 true 否则为 false
 *         BigInteger a = new BigInteger("123");
 *         BigInteger b = new BigInteger("456");
 *
 *         if(a.compareTo(b) == 0) System.out.println("a == b"); // a == b
 *         else if(a.compareTo(b) > 0) System.out.println("a > b"); // a > b
 *         else if(a.compareTo(b) < 0) System.out.println("a < b"); // a < b
 *         加法
 *
 *         BigInteger a = new BigInteger("123");
 *         BigInteger b = new BigInteger("456");
 *
 *         a.add(b);
 *         减法
 *
 *         BigInteger a = new BigInteger("123");
 *         BigInteger b = new BigInteger("456");
 *
 *         a.subtract(b);
 *         乘法
 *
 *         BigInteger a = new BigInteger("123");
 *         BigInteger b = new BigInteger("456");
 *
 *         a.multiply(b);
 *         除法
 *
 *         BigInteger a = new BigInteger("123");
 *         BigInteger b = new BigInteger("456");
 *
 *         a.divide(b);
 *         取余
 *
 *         BigInteger a = new BigInteger("123");
 *         BigInteger b = new BigInteger("456");
 *
 *         BigInteger c = b.remainder(a);
 *         System.out.println(c);
 *         除法取余
 *
 *         BigInteger a = new BigInteger("123");
 *         BigInteger b = new BigInteger("456");
 *
 *         BigInteger result[] = b.divideAndRemainder(a); // 该函数返回的是数组
 *         System.out.println("商是：" + result[0] + "；余数是：" + result[1]);
 *         最大公约数
 *
 *         BigInteger a = new BigInteger("12");
 *         BigInteger b = new BigInteger("56");
 *
 *         System.out.println(a.gcd(b)); // 4
 *         绝对值
 *
 *         BigInteger a = new BigInteger("-12");
 *
 *         System.out.println(a.abs()); // 12
 *         取反数
 *
 *         BigInteger a = new BigInteger("-12");
 *
 *         System.out.println(a.negate()); // 12
 *         幂
 *
 *         BigInteger a = new BigInteger("2");
 *
 *         System.out.println(a.pow(3)); // 8
 */

    }
}
