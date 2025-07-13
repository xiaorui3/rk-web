package w5;
import java.util.Scanner;

public class w1 {
    static Scanner scanf=new Scanner(System.in);
    public static void main(String[] args) {
        panduan n=new panduan();
        n.setShuzi_1(scanf.nextLong());
        n.zhuanhuan(n.getShuzi_1());

    }
}
