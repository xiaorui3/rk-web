package 集合练习;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class main2 {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("国境",1);
        map.put("傻逼",2);
        Set<String> map1=map.keySet();
        for (String s : map1) {
            String s1= String.valueOf(map.get(s));
            System.out.println(s+" "+s1);
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String s1=entry.getKey();
            Integer s2=entry.getValue();
            System.out.println(s1+" "+ s2);
        }
        Iterator<Map.Entry<String, Integer>> it = entries.iterator();



    }
}
