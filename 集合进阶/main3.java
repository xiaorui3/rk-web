package 集合进阶;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class main3 {
    public static void main(String[] args) {
        TreeMap<Character,Integer> ts=new TreeMap<>();
        String a="aabbddrggsd";
        for(int i=0;i<a.length();i++){
            char a1=a.charAt(i);
            if(ts.containsKey(a1)){
                Integer a2=ts.get(a1);
                a2++;
                ts.put(a1,a2);
            }
            else{
                ts.put(a1,1);
            }
        }
        ts.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character character, Integer integer) {
                System.out.println(character+" "+integer);
            }
        });
    }
}
