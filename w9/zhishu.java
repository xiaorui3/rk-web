package w9;

import java.math.BigInteger;

public class zhishu {
    public static void main(String[] args) {
        long kaishi=System.currentTimeMillis();
        for(int i=2;i<10000;i++){
            int a=0;
            for(int j=2;j<=Math.pow(i,0.5);j++){
                if(i%j==0){
                    a=1;
                    break;
                }
            }
            if(a==0){
                System.out.println(i);
            }
        }
        long jieshu=System.currentTimeMillis();
        System.out.println("时间为:"+(jieshu-kaishi));
    }
}
