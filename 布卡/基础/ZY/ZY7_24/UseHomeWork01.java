package 布卡.基础.ZY.ZY7_24;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UseHomeWork01 {
    public static void main(String[] args) {
        Person p1=new Person("张三",18);
        Person p2=new Person("张四",19);
        Person p3=new Person("张五",199);
        Person p4=new Person("张三",18);
        ArrayList<Person> arr1=new ArrayList<>();
        arr1.add(p1);arr1.add(p2);arr1.add(p3);arr1.add(p4);
        Set<Person> s1=new HashSet<>();
        Iterator<Person> iterator1 = arr1.iterator();
        while (iterator1.hasNext()){
            s1.add(iterator1.next());
        }
        s1.addAll(arr1);
        Iterator<Person> iterator = s1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
