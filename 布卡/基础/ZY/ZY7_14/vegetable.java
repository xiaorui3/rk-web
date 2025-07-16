package 布卡.基础.ZY.ZY7_14;

public class vegetable {
    public String name;
    public void Planted_in_the_ground(){
        System.out.println(this.name+"被种在了地里");
    }
    public void grow_up(){
        System.out.println(this.name+"正在生长");
    }
    public void ripe(){
        System.out.println(this.name+"成熟了");
    }
    public void pick(String name){
        System.out.println(this.name+"被"+name+"采摘了");
    }
    public void pick(){
        System.out.println(this.name+"被"+"采摘了");
    }
    public void Was_eat(String name){
        System.out.println(this.name+"被"+name+"吃了");
    }
    public void Was_eat(){
        System.out.println(this.name+"被吃了");
    }
}
