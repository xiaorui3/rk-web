package 算法;

import java.util.Scanner;

public class 寻找三个数最大的乘积 {
    static int N=100;
    static int[] a=new int[100];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int max=(int)-1e9;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    max=Math.max(max,a[i]*a[j]*a[k]);
                }
            }
        }
        System.out.println(max);
    }
}
