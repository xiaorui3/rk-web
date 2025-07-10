package java代码.数学库;

public class 指数运算 {
    /**
     *方法	说明
     *     static double exp(double a)	返回 e 的 a 次幂
     *     static double pow(double a,double b)	返回以 a 为底数，以 b 为指数的幂值
     *     static double sqrt(double a)	返回 a 的平方根
     *     static double cbrt(double a)	返回 a 的立方根
     *     static double log(double a)	返回 a 的自然对数，即 lna 的值
     *     static double log10(double a)	返回以 10 为底 a 的对数
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("4 的立方值：" + Math.pow(4, 3));
        System.out.println("16 的平方根：" + Math.sqrt(16));
        System.out.println("10 为底 2 的对数：" + Math.log10(2));
    }
/*           4 的立方值：64.0
            16 的平方根：4.0
            10 为底 2 的对数：0.3010299956639812*/
}
