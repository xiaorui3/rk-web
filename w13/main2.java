package w13;

import java.util.Scanner;

public class main2 {
    static Scanner lu=new Scanner(System.in);
    static int n=lu.nextInt();
    public static void main(String[] args) {
        int pai[]=new int[n];
        for(int i=0;i<n;i++){
            pai[i]=i;
        }
        for(int i=0;i<n;i++){

        }
    }
    public static void pailei(int i,int a[]){
        System.out.printf("%5d",a[i+1]);
        int p[]=new int[n-1];
        for(int j=0;j<n;j++){
            if(j!=i+1){
                p[j]=j+1;
            }
        }
    }
}
