package w10;

import java.math.BigInteger;
import java.util.Random;

public class main1 {
    public static void main(String[] args) {
        BigInteger big=new BigInteger("1000000000000000000000000000000000000000000000",16);
        BigInteger big1= BigInteger.valueOf(1000);
        System.out.println(big);
        Random sj=new Random();
        int []a=new int[1000000000];
        int []a1=new int[1000000000];
        int []a2=new int[1000000000];
        for(int i=0;i<=1000000000;i++) {
            a[i]=sj.nextInt(100, 200);System.out.println(Runtime.getRuntime().freeMemory());
            System.out.println(a[i]);
        }

    }
}
