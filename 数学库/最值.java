package java代码.数学库;

public class 最值 {
    /**
     * 方法	说明
     * static int abs(int a)	返回 a 的绝对值
     * static long abs(long a)	返回 a 的绝对值
     * static float abs(float a)	返回 a 的绝对值
     * static double abs(double a)	返回 a 的绝对值
     * static int max(int x,int y)	返回 x 和 y 中的最大值
     * static double max(double x,double y)	返回 x 和 y 中的最大值
     * static long max(long x,long y)	返回 x 和 y 中的最大值
     * static float max(float x,float y)	返回 x 和 y 中的最大值
     * static int min(int x,int y)	返回 x 和 y 中的最小值
     * static long min(long x,long y)	返回 x 和 y 中的最小值
     * static double min(double x,double y)	返回 x 和 y 中的最小值
     * static float min(float x,float y)	返回 x 和 y 中的最小值
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("10 和 20 的较大值：" + Math.max(10, 20));
        System.out.println("15.6 和 15 的较小值：" + Math.min(15.6, 15));
        System.out.println("-12 的绝对值：" + Math.abs(-12));
    }
    /*
    *
10和20的较大值：20
15.6和15的较小值：15.0
-12的绝对值：12
    *
    * */
}
