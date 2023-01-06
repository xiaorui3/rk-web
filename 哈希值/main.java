package 哈希值;

public class main {
    public static void main(String[] args) {
        student stu=new student("zhangsan",23);
        student stu1=new student("lisi",24);
        int i1 = stu.hashCode();
        System.out.println(i1);
        int i = stu1.hashCode();
        System.out.println(i);
        System.out.println("abc".hashCode());
        System.out.println("acD".hashCode());
    }
}
