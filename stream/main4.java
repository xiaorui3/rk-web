package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class main4 {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<100;i++){
            arr.add(i);
        }
        Stream<Integer> stream=arr.stream();
        Stream<Integer> stream1 = stream.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer%3==0){
                    return true;
                }
                return false;
            }
        });
        Stream<Integer> stream2 = stream1.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer%2==0){
                    return true;
                }
                return false;
            }
        });
        stream2.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer+" ");
            }
        });
        System.out.println();
        System.out.println("=================================");
        arr.stream().filter(s->s%3==0).filter(s->s%2==0).forEach(s-> System.out.print(s+ " "));
        Stream<Integer> stream3 = arr.stream();
        Stream<String> stringStream = stream3.map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                String s = integer.toString();
                return s;
            }
        });
        //stringStream.forEach(s-> System.out.println(s));
        System.out.println();
        String[] l= arr.stream().toArray(new IntFunction< String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
    }
}
