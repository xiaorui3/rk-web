package lanqiaomoni;

import java.util.ArrayList;
import java.util.Scanner;

public class main4 {
    public static void main(String[] args) {
        Scanner lu=new Scanner(System.in);
        ArrayList <Integer> arr=new ArrayList<>();
        int num1=lu.nextInt();
        int num=num1;
        while(num1--!=0){
            arr.add(lu.nextInt());
        }
        int max=0,min=100;double s=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>max){
                max=arr.get(i);
            }
            if(arr.get(i)<min){
                min=arr.get(i);
            }
            s=s+ arr.get(i);
        }
        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f",s);
    }
}
