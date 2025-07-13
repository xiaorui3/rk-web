package 集合;

import java.util.ArrayList;
import java.util.Collection;

public class main {
    public static void main(String[] args) {
        Collection<String> coll=new ArrayList<>();
        coll.add("aaaa");
        coll.add("bbbb");
        coll.add("cccc");
        System.out.println(coll);
        //coll.clear();
        coll.remove("aaaa");
        System.out.println(coll);
        System.out.println(coll.contains("aaaa"));
        Collection<Student> stu=new ArrayList<>();
        Student s1=new Student("zhangsan",23);
        Student s2=new Student("lisi",24);
        Student s3=new Student("wangwu",25);
        Student s4=new Student("laoliu",26);
        stu.add(s1);stu.add(s2);stu.add(s3);stu.add(s4);
        Student s5=new Student("lisi",24);
        if(stu.contains(s5)) {System.out.println(stu.size());
            stu.remove(s5);
        }
        System.out.println(stu.contains(s5));
        System.out.println(stu.size());
    }
}
