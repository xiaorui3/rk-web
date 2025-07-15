package test;

public class TestMain {

    public static void main(String[] args) {
        //0.类加载
        //1.创建对象
        Teacher t = new Teacher();
        //父类无参数构造
        //Teacher无参数构造

        t.teach();




            //虽然有了Teacher对象，TestMain范围不在受保护的范围里
        //2.调用属性/方法
//        t.name = "zzt";
//        t.age = 18;
//        t.zhiCheng = "高级工程师";
//        t.eat();
//        t.teach();
//        //=============================
//        System.out.println("================");
//        Student s = new Student();
//        s.name = "小明";
//        s.age = 10;
//        s.number = 1001;
//        s.eat();
//        s.study();

    }

}
