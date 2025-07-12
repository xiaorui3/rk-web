package 布卡.基础.ZY.ZY7_11;

import java.util.Arrays;

public class zy06 {
    public static void main(String[] args) {
        int p=0;
        int[] arr =new int[100];
        for (int i=2;i<=100;i++){
            int j=2;
            for (;j<=i;j++){
                if (i%j==0){
                    break;
                }
            }
            if (j==i){
                //System.out.println(i+"是素数");
                arr[p++]=i;

            }else{
                //System.out.println(i+"不是素数");
            }

        }
        int[] arrL=new int[p];
        for (int i=0;i<p;i++){
            arrL[i]=arr[i];
        }
        System.out.println(Arrays.toString(arrL));
    }
}
