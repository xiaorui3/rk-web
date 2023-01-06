package 集合进阶;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class main4 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,9,5,6,75,95,64,8,46,5);
        Integer max = Collections.max(list);
        System.out.println(max);
        System.out.println(list);
        Collections.swap(list,1,2);
        System.out.println(list);
    }
}
