package java代码.数学库;

public class 三角函数运算 {
    /**
     *  方法	说明
     *     static double sin(double a)	返回角的三角正弦值，参数以孤度为单位
     *     static double cos(double a)	返回角的三角余弦值，参数以孤度为单位
     *     static double asin(double a)	返回一个值的反正弦值，参数域在 [-1,1]，值域在 [-PI/2,PI/2]
     *     static double acos(double a)	返回一个值的反余弦值，参数域在 [-1,1]，值域在 [0.0,PI]
     *     static double tan(double a)	返回角的三角正切值，参数以弧度为单位
     *     static double atan(double a)	返回一个值的反正切值，值域在 [-PI/2,PI/2]
     *     static double toDegrees(double angrad)	将用孤度表示的角转换为近似相等的用角度表示的角
     *     staticdouble toRadians(double angdeg)	将用角度表示的角转换为近似相等的用弧度表示的角
     * @param args
     */
    public static void main(String[] args) {
            System.out.print("90 度的正弦值：" + Math.sin(Math.PI/2));
            System.out.println("0 度的余弦值：" + Math.cos(0));
            System.out.println("1 的反正切值：" + Math.atan(1));
            System.out.println("120 度的弧度值：" + Math.toRadians(120.0));
        }
/*          90 度的正弦值：1.0
            0 的余弦值：1.0
            1 的反正切值：0.7853981633974483
            120 度的弧度值：2.0943951023931953*/
}
