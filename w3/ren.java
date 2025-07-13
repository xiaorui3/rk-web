package w3;

public class ren {
    String name;
    String age;
    String shiwu;
    public void xingwei(dongwu a,String shiwu){
        String po;
        if(a instanceof cat){
            po="猫";
        }
        else if(a instanceof dog){
            po="狗";
        }
        else{
            po="外星人";
        }
        System.out.println("年龄为"+age+"的"+name+"在喂养自己的宠物"+po);
        if(a instanceof cat){
            cat c= (cat)a;
            c.eat(shiwu);
            c.zhuo();
        }
        else if(a instanceof dog){
            dog d=(dog)a;
            d.eat(shiwu);
            d.kanjia();
        }
        else{
            System.out.println("未知错误！");
        }
        
    }
    public ren(){}
    public ren(String name, String age, String shiwu) {
        this.name = name;
        this.age = age;
        this.shiwu = shiwu;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getShiwu() {
        return shiwu;
    }
    public void setShiwu(String shiwu) {
        this.shiwu = shiwu;
    }
}
