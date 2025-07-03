package 马士兵.JavaSE进阶.面向对象基础.类的编写;

/**
 * 创建一个Person类
 *
 * @author shkstart
 */
public class Person {
    //名词 属性
    int age;
    String name;
    char gender;

    //动词 业务 方法

    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }

    public void SpeakName() {//说话的英语是 ：
        System.out.println("我的名字是" + getName() + "!");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

