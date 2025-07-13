package w11;

import java.util.Scanner;

public class main3 {
    static Scanner lu=new Scanner(System.in);
    public static void main(String[] args) {
        int n=lu.nextInt();
        int k=lu.nextInt();
        int length=0;
        int[] n_1=new int[n];
        for(int i=0;i<n;i++){
            n_1[i]=lu.nextInt();
        }
        length=length+n_1[n_1.length-1];
        n=n-k-1;
        length=length+n_1[n-1];
        System.out.println(length);
//        for(int i=n-2;k!=0;i--){
//            n_1[i]=-1;k--;
//        }
//        for(int i=0;i< n_1.length;i++){
//            for(int j=0;j<n_1.length-i-1;j++){
//                if(n_1[j]>n_1[j+1]){
//                    int tap=n_1[j];n_1[j]=n_1[j+1];n_1[j+1]=tap;
//                }
//            }
//        }
//        length=length+n_1[n_1.length-2];
//        System.out.println(length);
    }
}
