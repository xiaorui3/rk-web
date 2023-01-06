package 链表;

import java.util.*;

public class main {
    public static void main(String[] args) {
        LinkedList<Integer> linked=new LinkedList<>();
        linked.add(123);
        linked.add(234);
        linked.add(1,123);
        System.out.println(linked);
        int[][] a=new int[1][1];
        Map<Integer,String> map=new HashMap<>();
        map.put(0,"123");
        map.put(1,"456");
        map.put(1,"123");
        System.out.println(map.get(1));
        Map map1=new HashMap<>();
        map1.putAll(map);
        Integer in = Integer.valueOf((String) map1.get(1)) ;
        System.out.println(in);
    }
}
