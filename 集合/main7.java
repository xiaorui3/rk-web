package 集合;

import java.util.Iterator;
import java.util.TreeSet;

public class main7 {
    public static void main(String[] args) {
        TreeSet<Student> tree=new TreeSet();
        Student s1=new Student("张三",23);
        Student s2=new Student("李四",24);
        Student s3=new Student("王五",24);
        tree.add(s2);
        tree.add(s1);
        tree.add(s3);
        for (Student student : tree) {
            System.out.println(student.getName()+" "+student.getAge());
        }
    }
}
