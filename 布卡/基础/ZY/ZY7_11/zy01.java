package 布卡.基础.ZY.ZY7_11;

import java.lang.reflect.Array;
import java.util.Arrays;

public class zy01 {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6,7,8,9};
        int sum=0;
        for(int i=0;i<arr1.length/2;i++){
            sum=arr1[i];
            arr1[i]=arr1[arr1.length-1-i];
            arr1[arr1.length-1-i]=sum;
        }
        System.out.println(Arrays.toString(arr1));
    }
}
