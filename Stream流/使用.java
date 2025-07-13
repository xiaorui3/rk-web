package java代码.Stream流;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class 使用 {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        Collections.addAll(arr,1,2,3,4,5,6,7);
        System.out.println(arr.stream().anyMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 1;
            }
        }));
        System.out.println(arr.stream().anyMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 8;
            }
        }));
        System.out.println(arr);
    }
}
