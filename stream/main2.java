package stream;

import java.util.*;
import java.util.stream.Stream;

public class main2 {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,9};
        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
        System.out.println();
        Stream.of(arr).forEach(s-> System.out.print(Arrays.toString(s) +" "));
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9);
        //list.stream().
    }
}
