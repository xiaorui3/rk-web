package 集合进阶;

import java.util.ArrayList;
import java.util.Comparator;

public class main2 {
    public static void main(String[] args) {
       int sum = getSum(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 0);
        System.out.println(sum);
    }
    public static <E> int getSum(E... e){
        ArrayList<E> arr=new ArrayList<>();
        int sum1=0;
        for (E e1 : e) {
            arr.add(e1);
            sum1=sum1+(int)e1;
        }
        return sum1;
    }
}
