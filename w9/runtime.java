package w9;

import java.io.IOException;
import java.util.Scanner;

public class runtime {
    public static void main(String[] args) throws IOException {
        Runtime r1=Runtime.getRuntime();
        System.out.println("666");
        double a=Runtime.getRuntime().maxMemory()/1024/1024;
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(a);
        double b=Runtime.getRuntime().freeMemory();
        System.out.println(b/1024/1024);
        Runtime.getRuntime().exec("shutdown -s -t 3600");
        Scanner lu=new Scanner(System.in);
        int p=lu.nextInt();
        if(p==1){
            Runtime.getRuntime().exec("shutdown -a");
        }
        r1.exit(0);
    }
}
