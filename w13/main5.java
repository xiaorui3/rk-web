package w13;

import java.util.Scanner;

public class main5 {
    static Scanner lu=new Scanner(System.in);
    static int n=lu.nextInt();
    static int pai[]=new int[n];
    static int pai1[]=new int[n];

    public static void main(String[] args) {
//        for(int i=0;i<n;i++){
//            pai[i]=i+1;
//        }
        shuru(n);
    }
    public static void shuru(int a){
        if(a==0){
            for(int i=0;i<n;i++){
                System.out.printf("%5d",pai1[i]);
            }
            System.out.println();
        }
        else{
            for(int i=1;i<=n;i++){
                if(pai[i-1]==1){
                    continue;
                }
                pai[i-1]=1;
                pai1[n-a]=i;
                shuru(a-1);
                pai[i-1]=0;
            }
        }
    }
}
