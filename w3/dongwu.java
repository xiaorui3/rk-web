package w3;

public class dongwu {
    int age;
    String yanse;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getYanse() {
        return yanse;
    }
    public dongwu(){}
    public dongwu(int age, String yanse) {
        this.age = age;
        this.yanse = yanse;
    }
    public void setYanse(String yanse) {
        this.yanse = yanse;
    }
    public void eat(String shiwu){
        System.out.println("动物在吃"+shiwu);
    }
    
}
