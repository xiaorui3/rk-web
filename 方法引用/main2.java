package 方法引用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class main2 {
    public static void main(String[] args) {
        Student stu1=new Student("张三",23);
        Student stu2=new Student("李四",24);
        Student[] stu=new Student[2];
        ArrayList<Student> arr=new ArrayList<>();
        Collections.addAll(arr,stu1,stu2);
        arr.toArray(Student[]::new);
        String[] s1 = arr.stream().map(new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName();
            }
        }).toArray(String[]::new);
        for (String s : s1) {
            System.out.println(s);
        }
        String [] s2 =  arr.stream().map(new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName() + "-" + String.valueOf(student.getAge());
            }
        }).toArray(String[]::new);
        for (String s : s2) {
            System.out.println(s);
        }
    }
}
