package 布卡.基础.排序算法;

import java.util.Arrays;

public class 冒泡 {
    public static void main(String[] args) {
        int[] arr =new int[]{1,3,5,7,9,8,6,4,2};
        int a=1;
        for (int i = 1; i < arr.length; i++) {
            boolean b=true;//做一个
            for (int j = 0; j < arr.length; j++) {
                if (arr[i]<arr[j]){
                    b=false;
                    a=arr[i];
                    arr[i]=arr[j];
                    arr[j]=a;
                }
            }
            if (b){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
