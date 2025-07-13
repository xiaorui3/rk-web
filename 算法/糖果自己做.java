package 算法;

import java.util.Random;
import java.util.Scanner;

public class 糖果自己做 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        Random r =new Random();
        int a=0;
        int b,sum=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sum=sum+arr[i];
        }
        for(int i=0;i<sum;i++){
            b = r.nextInt(n);
            if(a==b){
                i--;
                continue;
            }
            if(arr[b]==0){
                i--;
                continue;
            }
            arr[b]--;
            a=b;
        }
        int sum1=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                sum1++;
            }
        }
        if(sum1==sum){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
/*    public static boolean arrList(int[] arr){
        for (int i = 0; i < arr.length; i++) {

        }
        return false;
    }*/
}
