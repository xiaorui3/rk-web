package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class main5 {
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        Collections.addAll(arr,"zhangsan,23","lisi,24","wangwu,25");
        Map<String, Integer> collect = arr.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (Integer.parseInt(s.split(",")[1]) >= 24) {
                    return true;
                }
                return false;
            }
        }).collect(Collectors.toMap(
                new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split(",")[0];
                    }
                },
                new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.valueOf(s.split(",")[1]);
                    }
                }));
        System.out.println(collect);

    }
}
