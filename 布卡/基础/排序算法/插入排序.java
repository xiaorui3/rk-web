package 布卡.基础.排序算法;

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr={4,5,8,7,9,21,4,6,2,4,6};
        for (int i = 0; i < arr.length; i++) {
            int tmp=0;
            boolean b=false;
            for (int j=i;j<arr.length;j++){
                if (b){
                    break;
                }
                if (arr[i]>arr[j]){
                    b=true;
                    tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
