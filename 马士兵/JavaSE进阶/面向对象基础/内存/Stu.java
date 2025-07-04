package 马士兵.JavaSE进阶.面向对象基础.内存;

public class Stu extends  Pre implements Comparable<Stu>{
    int id;
    int  age;

    public Stu(){
        System.out.println("无参构造方法");
    }
    public Stu(int age){
        this.age =age;
        System.out.println("无参构造方法");
    }
    public void eat(){
        System.out.println("吃吃吃");
    }

    public static void main(String[] args) {
        Stu s1=new Stu();
        s1.eat();
        s1.id=1;
        s1.age=18;
        Stu s2=new Stu(13);
        System.out.println(s1.compareTo(s2));

    }

    @Override
    public int compareTo(Stu o) {
        return this.age-o.age;
    }
}
