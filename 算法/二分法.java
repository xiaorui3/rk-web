package 算法;

public class 二分法 {
    public static void main(String[] args) {
        int arr[]={7,23,79,81,103,127,131,147};
        int number=150;
        int min=0,max=arr.length-1;
        int mid=(min+max)/2;
        while(arr[mid]!=number){
            if(arr[mid]>number){
                max=mid-1;
                mid=(min+max)/2;
            }
            else{
                min=mid+1;
                mid=(min+max)/2;
            }
            if(min>max){
                System.out.println("数据超");
                break;
            }
        }
        System.out.println(mid);
    }


}
