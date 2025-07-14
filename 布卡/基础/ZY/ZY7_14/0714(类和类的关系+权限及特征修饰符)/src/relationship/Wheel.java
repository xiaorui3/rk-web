package relationship;

//车轮子
public class Wheel {

    //品牌
    public String brand;
    //型号
    public int size;

    //带参数的构造方法
    public Wheel(){}

    public Wheel(String brand,int size){
        this.brand = brand;
        this.size = size;
    }

    //能转--方法
    public void round(){
        System.out.println(this.brand+this.size+"的车轮子，转的嗷嗷快");
    }
}
