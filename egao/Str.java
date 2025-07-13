package egao;

import java.util.Objects;

public class Str implements Cloneable{
    String name;
    int age;
    int[] a11=new int[10];

    public Str(String name, int age, int[] a11) {
        this.name = name;
        this.age = age;
        this.a11 = a11;
    }

    public int[] getA() {
        return a11;
    }

    public void setA(int[] a) {
        this.a11 = a;
    }

    public Str() {
    }

    public Str(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Str str = (Str) o;
        return age == str.age && Objects.equals(name, str.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Str{name = " + name + ", age = " + age + "}";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 获取
     * @return a11
     */
    public int[] getA11() {
        return a11;
    }

    /**
     * 设置
     * @param a11
     */
    public void setA11(int[] a11) {
        this.a11 = a11;
    }
}
