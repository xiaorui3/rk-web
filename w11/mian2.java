package w11;

import java.util.Scanner;


public class mian2 {
   // static
    public static void main(String[] args) {
        Scanner lu=new Scanner(System.in);
        long kai=System.currentTimeMillis();
        int n=lu.nextInt();
        int m=lu.nextInt();
        int q=lu.nextInt();
        int n_1[]=new int[n];
        int m_1[]=new int[m];
        int q_1[]=new int[q];long jie=System.currentTimeMillis();System.out.println("总用时:"+(jie-kai));
        for(int i=1;i<=m;i++){
            m_1[i-1]=i;
        }
        for(int i=0;i<n;i++){
            n_1[i]=lu.nextInt();
        }
        for(int i=0;i<q;i++){
            q_1[i]=lu.nextInt();
        }
        for(int i=0;i<q;i++){
            int chuko=0;
            for(int j=0;j<n;j++){
                if(q_1[i]!=n_1[j]){
                    chuko++;
                }
            }
            System.out.println(chuko);
        }


    }
}
