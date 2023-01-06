package lanqiaomoni;

import java.util.Scanner;

public class main9 {
    public static void main(String[] args) {
        Scanner lu=new Scanner(System.in);
        long n= lu.nextLong();
        long sum=0;
        for(long i=1;i<=n;i++){
            for(long j=1;j<=n;j++){
                for(long z=1;z<=n;z++){
                    if((long) i *j*z==n){
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
