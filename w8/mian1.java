package w8;

import java.util.Scanner;

public class mian1 {
    public static void main(String[] args) {
        Scanner lu=new Scanner(System.in);
        int n=lu.nextInt();
        int k[][]=new int[n][3];
        int k_1[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                k[i][j]=lu.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            int p=0;
            for(int j=0;j<3;j++){
                p=p+k[i][j];
            }
            k_1[i]=p;
        }
        int duisho=0;
            for(int j=0;j<n-1;j++){
                int n_2=0,n_3=0;
                if(k_1[j]-k_1[j+1]<=5&&k_1[j]-k_1[j+1]>=-5)
                for(int m=j+1;n_3<3;n_3++){
                    if(k[j][n_3]-k[m][n_3]<=5&&k[j][n_3]-k[m][n_3]>=-5){
                        n_2++;
                        if(n_2==3){
                            duisho++;
                        }
                    }
                    else{
                        m=n;
                    }
                }
                else{
                    j=n-1;
                }
            }
        System.out.println(duisho);
    }
}
