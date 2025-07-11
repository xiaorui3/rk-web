package 布卡.基础.ZY.ZY7_11;

import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        int[] arr =new int[]{1,3,5,7,9,8,6,4,2};
        int sum=0;
        for(int v:arr){
            sum+=v;
        }
        System.out.println(sum);


        Scanner sc =new Scanner(System.in);
        int num = sc.nextInt();
        int p=0;
        for (int v:arr){
            if (v==num){
                System.out.println(num+"存在找到啦");
                p=1;
            }
        }
        if (p==0){
            System.out.println(num+"不存在");
        }

    }
}
