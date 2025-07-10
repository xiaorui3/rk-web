package java代码.继承多态接口;

public class 继承 {
    public static void main(String[] args) {

    }


}
abstract class 父1 {

    private String name;
    static int age=1;

    public 父1() {
    }

    public 父1(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }
    public static int get(){
        return age;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "父1{name = " + name + "}";
    }
}
class 子1 extends 父1{
    public 子1() {
    }
}
abstract class 父2 {

}
class 子2{

}
class 父3 {

}
class 子3{

}
