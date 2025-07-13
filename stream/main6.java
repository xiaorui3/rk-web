package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main6 {
    public static void main(String[] args) {
        ArrayList<String> arr1=new ArrayList<>();
        Collections.addAll(arr1,"杨国问,23","肯里齐,24","王文强,25","皮哦琼,26","李文,27","吴曲,28");
        ArrayList<String> arr2=new ArrayList<>();
        Collections.addAll(arr2,"小龙女,23","杨期,24","杨五,25","安稳,26","文强,27","挖的,28");
        //男
        Stream<String> limit1 = arr1.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.split(",")[0].length() == 3) {
                    return true;
                }
                return false;
            }
        }).limit(2);
        //女
        Stream<String> limit2 = arr2.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (String.valueOf(s.charAt(0)).equals("杨")) {
                    return true;
                }
                return false;
            }
        }).limit(1);
        Stream<String> concat = Stream.concat(limit1, limit2);
        Stream<Actor> actorStream = concat.map(new Function<String, Actor>() {
            @Override
            public Actor apply(String s) {
                return new Actor(s.split(",")[0], Integer.parseInt(s.split(",")[1]));
            }
        });
        List<Actor> collect = actorStream.toList();
        System.out.println(collect);
    }
}
