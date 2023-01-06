package 异常;

import java.util.Objects;

public class g {
    private String name;
    private String age;

    public g() {
    }

    public g(String name, int String) {
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
    public boolean setName(String name) throws RuntimeException{
        if(name.length()>=3&&name.length()<=10){
            this.name = name;
            return true;
        }
        else{
            System.out.println("录入姓名错误");
            return false;
        }
    }

    /**
     * 获取
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public boolean setAge(String age) throws RuntimeException{
        int a,a1=1;
        try{
            a= Integer.parseInt(age);
        }catch (NumberFormatException e){
            a= 0;
            a1=-1;
        }
        if(age.equals(String.valueOf(a))){
            if(a>=18&&a<=40){
                this.age = age;
                return true;
            }
            else{
                if(a1>0){
                    System.out.println("录入年龄错误");
                }
                return false;
            }
        }
        else{
            System.out.println("含有非数字字符");
            return false;
        }
    }

    public String toString() {
        return "g{name = " + name + ", age = " + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        g g = (g) o;
        return age == g.age && Objects.equals(name, g.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
