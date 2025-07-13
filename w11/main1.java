package w11;

import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner lu=new Scanner(System.in);
        int n= lu.nextInt();
        int[] a=new int[n];
        int k=lu.nextInt();
        for(int i=0;i<n;i++){
            a[i]=lu.nextInt();
        }
        for(int i=0;i<a.length;i++){
            for(int j=0;j< a.length-i-1;j++){
                if(a[j]>a[j+1]) {
                    int sum = a[j];
                    a[j] = a[j+1];
                    a[j+1] = sum;
                }
            }
        }
        System.out.println(a[k]);
    }
}
