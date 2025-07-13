package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.IntFunction;

public class main7 {
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        Collections.addAll(arr,"aaa","bbb","ppp","ccc");
        arr.stream().map(new Function<String, String>() {

            @Override
            public String apply(String s) {
                String s1 = s.toUpperCase();
                return s1;
            }
        }).forEach(s-> System.out.print(s+" "));
        System.out.println();
        arr.stream().map(String::toUpperCase).forEach(s-> System.out.print(s+" "));
        System.out.println();
        String[] s = arr.toArray(String[]::new);
        for (String value : s) {
            System.out.println(value);
        }
    }
}
