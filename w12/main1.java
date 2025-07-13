package w12;

import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner lu=new Scanner(System.in);
        int n=lu.nextInt();
        int m=lu.nextInt();
        int[] m_1=new int[m];
        for(int i=0;i<m_1.length;i++){
            m_1[i]= lu.nextInt();
        }
        for(int i=0;i< m_1.length;i++){
            for(int j=1;j< m_1.length-i;j++){
                if(m_1[j-1]>m_1[j]){
                    int temporary_int=m_1[j-1];
                    m_1[j-1]=m_1[j];
                    m_1[j]=temporary_int;
                }
            }
        }
        for(int i=0;i<m_1.length;i++){
            System.out.print(m_1[i]+" ");
        }
    }
}
