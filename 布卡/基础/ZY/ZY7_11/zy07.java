package 布卡.基础.ZY.ZY7_11;

public class zy07 {
    public static void main(String[] args) {
        int[] arr1={1,2,5,6,8};
        int[] arr2={1,3,4,5,6,9};
        int[] arr3=new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while (i<arr1.length&&j<arr2.length){
            if (arr1[i]<arr2[j]){
                arr3[k]=arr1[i];
                i++;
            }else {
                arr3[k]=arr2[j];
                j++;
            }
            k++;
        }
        while (i<arr1.length){
            arr3[k]=arr1[i];
            i++;
            k++;
        }
        while (j<arr2.length){
            arr3[k]=arr2[j];
            j++;
            k++;
        }
        for (int i1 = 0; i1 < arr3.length; i1++) {
            System.out.print(arr3[i1]+" ");
        }
        System.out.println();
    }
}
