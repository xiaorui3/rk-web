package 布卡.基础.ZY.ZY7_11;

import java.util.Arrays;

public class zy05 {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,0,2,4,0,6,0,8,7,0,1};
        int m=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                m++;
            }
        }
        int[] arr1=new int[arr.length-m];
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0){
                arr1[j++]=arr[i];
            }

        }
        System.out.println(Arrays.toString(arr1));
    }
}
