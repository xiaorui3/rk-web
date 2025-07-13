package 集合;

import java.util.*;

public class main4 {
    public static void main(String[] args) {
        Collection<String> coll=new ArrayList<>();
        coll.add("aaa");coll.add("bbb");coll.add("ccc");
        for (String s : coll) {
            System.out.print(s+" ");
        }
        System.out.println();
        Iterator<String> it= coll.iterator();
        String a="aaa";
        while(it.hasNext()){
            String next = it.next();
            if(a.equals(next)){
                it.remove();
            }
            System.out.print(next+" ");
        }
        System.out.println();
        System.out.println(coll);
        List <Integer> list=new ArrayList<>();
        list.add(0,11);
        Integer b=Integer.valueOf("123");
        list.add(b);

    }
}
