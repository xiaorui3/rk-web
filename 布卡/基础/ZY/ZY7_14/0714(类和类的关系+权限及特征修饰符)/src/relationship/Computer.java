package relationship;

public class Computer {

    //品牌
    public String brand;
    //颜色
    public String color;

    public Computer(String brand,String color){
        this.brand = brand;
        this.color = color;
    }

    public void beUsed(){
        System.out.println("被使用中。。。");
    }

}
