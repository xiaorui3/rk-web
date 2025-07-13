import java.util.Scanner;

public class 蓝桥模拟 {
    public static void main(String[] args) {
        int[] a = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 31};
        int[] b = {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Scanner scan = new Scanner(System.in);
        String nina = scan.next();
        int shu = 0;
        int p= Integer.valueOf(nina).intValue();
        for (p=p+1; p <= 99999999; p++) {
            if(p>31211231){
                continue;
            }
            if (shu == 2) {
                break;
            }
            String s = String.valueOf(p);
            int s1 = s.charAt(4)-48;
            int s2 = s.charAt(5)-48;
            int s1s2 = s2 + (s1 * 10);

            if (s1s2 >= 13&&s1s2!=0) {
                continue;
            }
            int s3 = s.charAt(6)-48;
            int s4 = s.charAt(7)-48;
            int s3s4 = s4 + (s3 * 10);
            int s5 = s.charAt(0)-48, s6 = s.charAt(1)-48, s7 = s.charAt(2)-48, s8 = s.charAt(3)-48;
            int ss = s5 * 1000 + s6 * 100 + s7 * 10 + s8;
            if ((0 == ss % 4 && ss % 100 != 0) || (0 == ss % 400)) {
                a[2] = 29;
                int m1=s5,m2=s6;//ABABBABA
                if (s3s4 <= a[b[s1s2]]&s3s4!=0) {
                    if ( s7 == m1 & s8 == m2 & s1 == m2 & s2 == m1 & s3 == m2 & s4 == m1) {
                        shu++;
                        System.out.println(p);
                    }
                    a[2] = 28;
                } else {
                    a[2] = 28;
                    continue;
                }
            } else {
                if (s3s4 <= a[b[s1s2]]&&s3s4!=0) {
                    int m1=s5,m2=s6;
                    if ( s7 == m1 & s8 == m2 & s1 == m2 & s2 == m1 & s3 == m2 & s4 == m1) {
                        shu++;
                        System.out.println(p);
                    }
                } else {
                    continue;
                }
            }
        }scan.close();
    }
}
