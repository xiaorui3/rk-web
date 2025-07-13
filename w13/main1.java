package w13;

import java.util.ArrayList;
import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner lu=new Scanner(System.in);
        int n=lu.nextInt();int n_1[]=new int[n];
        for(int i=0;i<n_1.length;i++){
            n_1[i]=i+1;
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                if(j!=1){
                    int leng=n-j;
                    int temp=n_1[leng];
                    n_1[leng]=n_1[leng+1];
                    n_1[leng+1]=temp;
                }
                for(int k=0;k<n;k++){
                    System.out.print(n_1[k]+" ");
                }
                System.out.println();
            }
//            int k_1=n_1[0];
//            for(int i_1=1;i_1<n;i_1++){
//                int j_1=n_1[i_1-1];
//                n_1[i_1-1]=n_1[i_1];
//                n_1[i_1]=j_1;
//            }
//            n_1[n-1]=k_1;
            int k_1=n_1[n-1];
            n_1[n-1]=0;
            for(int i_1=n-2;i_1>=0;i_1--){
                int j_1=n_1[i_1];
                n_1[i_1]=n_1[i_1+1];
                n_1[i_1+1]=j_1;
            }
            n_1[0]=k_1;
        }
    }
}
