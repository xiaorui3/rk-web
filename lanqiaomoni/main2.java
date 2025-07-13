package lanqiaomoni;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner lu=new Scanner(System.in);
        int num1=lu.nextInt();double num=num1;
        int jige=0,youxiu=0;
        while (num1--!=0){
            int linshi=lu.nextInt();
            if(linshi>=60){
                jige++;
                if(linshi>=85){
                    youxiu++;
                }
            }
        }
        double a=Math.ceil((jige/num)*100),b=Math.ceil((youxiu/num)*100);
        int a1=(int)a;
        int b1=(int)b;
        System.out.println(a1+"%\n"+b1+"%\n");
    }
}
