package 算法;


import java.util.ArrayList;

public class 基本算法 {//基本查找
    public static void main(String[] args) {
        int arr[]={131,127,147,81,103,23,7,79,81};
        ArrayList<Integer> arr1= 基本查找1(arr,81);
        for(int i=0;i< arr1.size();i++){
            System.out.print(arr1.get(i)+" ");
        }
    }
    public static boolean 基本查找(int arr[],int number){
        for (int i = 0; i < arr.length; i++) {
            if(number==arr[i]){
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Integer> 基本查找1(int arr[], int number){
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i< arr.length;i++){
            if(number==arr[i]){
                a.add(i);
            }
        }
        return a;
    }
}
