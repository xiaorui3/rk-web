package w13;

import java.util.Scanner;

public class main4 {
    static Scanner lu=new Scanner(System.in);
    static int n=lu.nextInt();
    static int[] pai=new int[n];
    static int k=n-2;
    static int m=0;
    static int p=n-1;
    public static void main(String[] args) {
        for(int i=0;i<n;i++){
            pai[i]=i+1;
        }
        for(int i=0;i<n;i++){
            System.out.printf("%5d",pai[i]);
            int[] pai1=new int [n-1];
            int j_1=0;
            for(int j=0;j<n;j++){
                if(j+1!=i+1){
                    pai1[j_1]=j+1;
                    j_1++;
                }
            }digui(pai1);
        }
    }
    public static void digui(int[] pai1){
        if(m!=k+1){
            System.out.printf("%5d",pai1[m]);
            m++;
            digui(pai1);
        }
        else{
            m=0;
            System.out.println();
            duigui1(pai1);
        }
    }
    public static void duigui1(int []pai1){

    }
}
