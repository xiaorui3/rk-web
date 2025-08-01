package 布卡.基础.ZY.ZY8_01;

public class Student extends Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("学生在跑步 "+this.name);
    }
}
