package 马士兵.算法;

import java.util.Arrays;

public class 冒泡排序 {
    public static void maoPaoSort(int arr[]){
        for (int i = arr.length-1; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr={4,5,8,7,9,21,4,6,2,4,6};
        test(arr);
    }




















    public static void test(int[] arr){
        if (arr.length<2||arr==null){
            return;
        }
        for (int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
