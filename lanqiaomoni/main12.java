package lanqiaomoni;

import java.util.Scanner;

public class main12 {
    static int a = 0, b = 0, m = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*        int s=sc.nextInt();
        m=m+s;
        extracted(s);
        while(a>=3){
            a=a-3;m++;b++;
        }
        b=b+a;
        while(b>=3){
            b=b-3;
            m++;
        }
        System.out.println(m+1);*/
        int s = sc.nextInt();

    }
    private static void extracted(int s) {
        while(s!=0){
            if(s < 3){
                b = b+s;
                break;
            }
            s = s -3;
            a++;m++;
        }
    }
}
