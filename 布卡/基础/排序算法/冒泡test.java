package 布卡.基础.排序算法;

import java.util.Arrays;

public class 冒泡test {
    public static void main(String[] args) {
        int[] arr =new int[]{9,3,5,7,9,8,6,4,2};
        for (int i = 1; i < arr.length; i++) {
            int p=0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j-1]>arr[j]){
                    p=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=p;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
