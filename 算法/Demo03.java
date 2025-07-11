package 算法;

import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int sum=0;
        String s = Integer.toString(n, 16);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                sum++;
            }
        }
        int i = Integer.reverseBytes(Integer.parseInt(s));
        System.out.println(i);
        System.out.println(s);
    }
}
