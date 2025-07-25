package 布卡.基础.ZY.ZY7_23;

import java.math.BigInteger;
import java.util.jar.JarEntry;

public class test {
    public static void main(String[] args) {
        Integer i=Integer.MIN_VALUE;
        if (i<0 && i==-i){
            System.out.println("1 "+ i);
        }

        System.out.println(jieCheng(1000));

    }
    public  static BigInteger jieCheng(int b){
        BigInteger b1=new BigInteger("1");
        for (int i = 1; i < b; i++) {
            b1=b1.multiply(new BigInteger(String.valueOf(i)));
        }
        return b1;
    }
}
