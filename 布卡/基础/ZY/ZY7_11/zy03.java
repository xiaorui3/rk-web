package 布卡.基础.ZY.ZY7_11;

import java.util.Arrays;

public class zy03 {
    public static void main(String[] args) {
        int[] arr1={1,3,2};
        int[] arr2={5,4};
        int[] arr3=new int[arr1.length+arr2.length];
        for (int i = 0; i < arr3.length; i++){
            if (i<arr1.length){
                arr3[i]=arr1[i];
            }else if(i-arr1.length<arr2.length){
                arr3[i]=arr2[i-arr1.length];
            }

        }
        System.out.println(Arrays.toString(arr3));
    }
}
