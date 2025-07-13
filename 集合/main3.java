package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class main3  {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);list.add(2);list.add(3);
        list.add(3,4);
        Integer i=Integer.valueOf(4);
        Integer n=Integer.valueOf("80");
        Integer m=Integer.valueOf("101010100",2);
        int a=1010100010;
        Integer m_1=Integer.valueOf(String.valueOf(a),2);
        System.out.println(m);
        System.out.println(n);
        System.out.println(list);
        list.remove(i);
        System.out.println(list);
        System.out.println("--------------------------------");
        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println("--------------------------------");
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println("--------------------------------");
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer+" ");
            }
        });
    }
}
