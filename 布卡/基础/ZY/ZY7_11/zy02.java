package 布卡.基础.ZY.ZY7_11;

public class zy02 {
    public static void main(String[] args) {
        int[] arr ={1,3,5,7,9,8,6,4,2};
        int max=0;
        int min=100000000;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]>max){
                max=arr[i];
            }
            if (arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("最大值为："+max);
        System.out.println("最小值为："+min);
    }
}
