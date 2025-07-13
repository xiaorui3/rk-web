package 接口;

public abstract class dongwu {
    String name;
    int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public dongwu(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract void chi();
}
