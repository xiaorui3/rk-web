package 算法;

import java.util.Scanner;

public class 二进制中1的个数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),sum=0;
        String s= Integer.toString(n,2);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                sum++;
            }
        }
        System.out.println(sum);
        System.out.println();
        int i = Integer.bitCount(n);
        System.out.println(i);
        System.out.println();
        String s1 = Integer.toBinaryString(n);
        sum=0;
        for(int j=0;j<s1.length();j++){
            if(s1.charAt(j)=='1'){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
