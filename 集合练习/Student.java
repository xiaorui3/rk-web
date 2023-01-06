package 集合练习;

import java.util.Objects;

public class Student implements Comparable<Student>{
    public int compare;
    private String name;
    private int age;
    private int yuwen;
    private int shuxue;
    private int yingyu;

    public Student() {
    }

    public Student(String name, int age, int yuwen, int shuxue, int yingyu) {
        this.name = name;
        this.age = age;
        this.yuwen = yuwen;
        this.shuxue = shuxue;
        this.yingyu = yingyu;
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

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return yuwen
     */
    public int getYuwen() {
        return yuwen;
    }

    /**
     * 设置
     * @param yuwen
     */
    public void setYuwen(int yuwen) {
        this.yuwen = yuwen;
    }

    /**
     * 获取
     * @return shuxue
     */
    public int getShuxue() {
        return shuxue;
    }

    /**
     * 设置
     * @param shuxue
     */
    public void setShuxue(int shuxue) {
        this.shuxue = shuxue;
    }

    /**
     * 获取
     * @return yingyu
     */
    public int getYingyu() {
        return yingyu;
    }

    /**
     * 设置
     * @param yingyu
     */
    public void setYingyu(int yingyu) {
        this.yingyu = yingyu;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + ", yuwen = " + yuwen + ", shuxue = " + shuxue + ", yingyu = " + yingyu + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && yuwen == student.yuwen && shuxue == student.shuxue && yingyu == student.yingyu && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, yuwen, shuxue, yingyu);
    }

    @Override
    public int compareTo(Student o) {
        int sum1=this.getShuxue()+this.getYingyu()+this.getYuwen();
        int sum2=o.getShuxue()+o.getYuwen()+o.getYingyu();
        int i=sum1-sum2;
         i= i == 0 ? this.getYuwen() - o.getYuwen() : i;
         i=i==0?this.getShuxue()-o.getShuxue():i;
        i=i==0?this.getYingyu()-o.getYingyu():i;
        i=i==0?this.getAge()-o.getAge():i;
        boolean i1= i==0&&this.getName().equals(o.getName());
        if(i1){
            i=0;
        }
        System.out.println(this.getName()+"总分:"+sum1);
        return i;
    }
}
