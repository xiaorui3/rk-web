package 布卡.基础.ZY.ZY7_11;

import java.util.Arrays;

public class zy04 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 9, 4, 5};
        //将数组按照最大值的位置拆分	---->	{1,2,3}	{4,5}
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("最大值为：" + max);
        int[] arr1 = null;
        int[] arr2 = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr1 = new int[i];
                arr2 = new int[arr.length - i - 1];
                for (int j = 0; j < i; j++) {
                    arr1[j] = arr[j];
                }
                for (int j = i + 1; j < arr.length; j++) {
                    arr2[j - i - 1] = arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
