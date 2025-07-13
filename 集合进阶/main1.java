package 集合进阶;


import java.util.Comparator;

import java.util.TreeMap;

public class main1 {
    public static void main(String[] args) {
        TreeMap<Integer,String> ts=new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int i=o1-o2;
                return -i;
            }
        });
        ts.put(2,"可乐");
        ts.put(3,"雪碧");
        System.out.println(ts);
        TreeMap<Student,String> ts1=new TreeMap<>();
        Student s1=new Student("小锐",19);
        ts1.put(s1,"黑龙江");
        Student s2=new Student("杨硕",18);
        ts1.put(s2,"黑龙江");
        System.out.println(ts1);

    }
}
