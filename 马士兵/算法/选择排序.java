package 马士兵.算法;

import java.util.Arrays;

public class 选择排序 {
    public static void selectSort(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }

        for (int i = 0; i < arr.length;i++) {
            int minIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                minIndex = arr[j]<arr[minIndex]?j:minIndex;
            }
            if (i!=minIndex){
                int tmp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=tmp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr={4,5,8,7,9,21,4,6,2,4,6};
        selectSort(arr);
    }
}
