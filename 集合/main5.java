package 集合;

import java.util.*;
import java.util.function.Consumer;

public class main5 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("张三");
        set.add("李四");
        set.add("王五");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
        set.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s + " ");
            }
        });
        System.out.println();
        set.forEach(s -> System.out.print(s+" "));
        System.out.println();
        Iterator <String> it=set.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
        LinkedHashSet<Integer> linked1=new LinkedHashSet<>();
        LinkedList<String> linked2=new LinkedList<>();
        linked2.add("123");
        linked2.add("234");
        linked2.add("234");
        String last = linked2.getLast();
        System.out.print(last+" ");
        for (String s : linked2) {
            System.out.print(s+" ");
        }
        System.out.println();
        linked1.add(1);
        linked1.add(2);
        linked1.add(3);
        for (Integer integer : linked1) {
            System.out.print(integer+" ");
        }
    }
}
