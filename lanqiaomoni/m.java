package lanqiaomoni;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class m {
    public static void main(String[] args) {
        int[] a = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 31};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Scanner scan = new Scanner(System.in);
        int nina = scan.nextInt();
        int shu = 0;
        for (int p = nina; p <= 99999999; p++) {
            if (shu == 2) {
                break;
            }
            String s = String.valueOf(p);
            int s1 = s.charAt(4);
            int s2 = s.charAt(5);
            int s1s2 = s2 + (s1 * 10);
            if (s1s2 >= 12) {
                continue;
            }
            int s3 = s.charAt(6);
            int s4 = s.charAt(7);
            int s3s4 = s4 + (s3 * 10);
            int s5 = s.charAt(0), s6 = s.charAt(1), s7 = s.charAt(2), s8 = s.charAt(3);
            int ss = s5 * 1000 + s6 * 100 + s7 * 10 + s8;

            if ((0 == ss % 4 && ss % 100 != 0) || (0 == ss % 400)) {
                a[2] = 29;
                if (s3s4 <= a[b[s1s2]]) {
                    if (s1 == s8 || s2 == s7 || s3 == s6 || s4 == s5) {
                        shu++;
                        System.out.println(p);
                    }
                    a[2] = 28;
                } else {
                    a[2] = 28;
                    continue;
                }
            } else {
                if (s3s4 <= a[b[s1s2]]) {
                    if (s1 == s8 || s2 == s7 || s3 == s6 || s4 == s5) {
                        shu++;
                        System.out.println(p);
                    }
                } else {
                    continue;
                }

            }
            scan.close();
        }
    }
}
