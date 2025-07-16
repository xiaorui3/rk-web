package 布卡.基础.ZY.ZY7_14;

public class person {
    public person(){

    }
    private int age;
    private String name;
    public void eat(){
        System.out.println(this.age+"的"+this.name+"在吃饭");
    }

    public person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sleep(){
        System.out.println(this.age+"的"+this.name+"在睡觉");
    }
}
