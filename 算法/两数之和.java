package 算法;

import java.util.Scanner;

public class 两数之和 {
    static int N=110;
    static int[] a=new int[N];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int t=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(i!=j&&a[i]+a[j]==t){
                    System.out.println(i+" "+j);
                    return;
                }
            }
        }
    }
}
