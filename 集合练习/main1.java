package 集合练习;

import java.util.*;

public class main1 {
    public static void main(String[] args) {
        Student s1=new Student("张三",18,87,94,86);
        Student s2=new Student("李四",19,85,84,86);
        Student s3=new Student("王五",22,78,65,45);
        Student s4=new Student("赵六",20,45,48,5);
        Student s5=new Student("杨七",17,18,18,98);
        TreeSet<Student> ts=new TreeSet<>();
        ts.add(s1);ts.add(s2);ts.add(s3);ts.add(s4);ts.add(s5);
        Iterator<Student> it=ts.iterator();
        while(it.hasNext()){
            Student next = it.next();
            System.out.println(next);
        }
    }
}
