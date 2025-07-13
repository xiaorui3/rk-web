package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class main2 {
    public static void main(String[] args) {
        Collection<String> coll =new ArrayList<>();
        coll.add("你");coll.add("好");coll.add("666");coll.add("世");coll.add("界");
        Iterator<String> it=coll.iterator();
        while(it.hasNext()){
            String next = it.next();
            if("666".equals(next)){
                it.remove();
            }
            System.out.print(next+" ");
        }
        coll.add("hello world");
        System.out.println();
        System.out.println("---------------------------------");
        for (String s : coll) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println("---------------------------------");
        coll.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s+" ");
            }
        });
        System.out.println();
        System.out.println("---------------------------------");
        coll.forEach((String s)->{
            System.out.print(s+" ");
        });
        System.out.println();
        System.out.println("---------------------------------");
        coll.forEach(s-> System.out.print(s+" "));
        System.out.println();
        System.out.println("---------------------------------");
    }
}
