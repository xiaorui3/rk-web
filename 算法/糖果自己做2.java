package 算法;

import java.util.Scanner;

public class 糖果自己做2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),max=0;long sum=0;
        for(int i=0;i<n;i++){
            int k=sc.nextInt();
            max=Math.max(max,k);
            sum=sum+k;
        }
        System.out.println(max* 2L >sum?"No":"Yes");
    }
}
