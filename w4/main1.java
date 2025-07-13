package w4;

import java.util.ArrayList;
import java.util.Scanner;

public class main1 {
    static Scanner lu=new Scanner(System.in);
    public static void main(String[] args) {
        int n=lu.nextInt();
        int[] p=new int[n];
        ArrayList<Integer> p1=new ArrayList<>();
        while(n!=0){
            int p2=p[p.length-n]=lu.nextInt();
            int p3=0;
            for(int i=6-n-1;i>=0;i--){
                if(p2>p[i]){
                    p3++;
                }
            }
            p1.add(p3);
            n--;
        }
        for(int i=0;i<p1.size();i++){
            System.out.printf("%d ",p1.get(i));
        }
    }
}
