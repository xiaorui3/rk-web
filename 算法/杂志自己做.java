package 算法;

import java.util.Scanner;

public class 杂志自己做 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        int i = a.indexOf(b);
        if (i < 0) {
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }
}
