package 布卡.基础.ZY.ZY7_25;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        HashMap<String,String> map =new HashMap<>();
        map.put("1","aaaa");
        map.put("2","bbbb");

        System.out.println(map.get("1"));
        System.out.println();
        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(map.get(iterator.next()));
        }

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator1 = entries.iterator();
        while(iterator1.hasNext()){
            Map.Entry<String, String> next = iterator1.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }


    }
}
