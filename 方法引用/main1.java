package 方法引用;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class main1 {
    public static void main(String[] args) {
/*        Integer[] arr={3,5,4,1,6,8,2};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o2+o1;
            }
        });
        System.out.println(Arrays.toString(arr));
        System.out.println();*/
/*        Integer[] arr={3,5,4,1,6,8,2};
        Arrays.sort(arr, Comparator.comparingInt(o -> o));
        System.out.println(Arrays.toString(arr));*/
        String[] str={"10","2","3","4","5","6"};
        ArrayList<String> arr2=new ArrayList<>();
        Collections.addAll(arr2,str);
/*        arr2.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer+" ");
            }
        });*/
        //str=Integer::valueOf;
        Iterator<String> iterator = arr2.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return true;
            }
        }).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        }).takeWhile(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return true;
            }
        }).iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.print("666");
    }
}
