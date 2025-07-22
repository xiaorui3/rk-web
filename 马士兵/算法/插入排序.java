package 马士兵.算法;

import java.util.Arrays;

public class 插入排序 {
    public static void chaRuSort(int[] arr){
        for (int i = 1; i < arr.length-1; i++) {
            for (int j = i; j >=0; j--) {
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
        int[] arr={4,5,8,7,9,21,4,6,2,4,6,23,4,3,4,32,312,3,21,4,34};
        test(arr);
        test02(arr);
    }


    public static void test(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j >=0; j--) {
                if (arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));


    }

    public static void test02(int[] arr){
        for (int i = arr.length-1; i>=0; i--) {
            for (int j = 0; j <arr.length-1 ; j++) {
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
