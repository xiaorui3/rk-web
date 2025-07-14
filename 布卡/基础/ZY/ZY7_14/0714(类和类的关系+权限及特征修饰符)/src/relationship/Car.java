package relationship;

//小汽车
public class Car {

    //品牌
    public String brand;//Benz BMW Poerche
    //型号
    public String size;//车型 Z4  R8  911
    //颜色
    public String color;

    //轮子对象放在小汽车中作为属性-------has a
    //public Wheel wheel;//------------has a  聚合关系

    //如果觉得一个轮子不合理，存储四个轮子        数组  int[]  String[]   int[][]
    public Wheel[] wheels = new Wheel[4];   //聚集

    public Car(){}
    public Car(String brand,String size,String color,Wheel[] wheels){
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.wheels = wheels;
    }

    //能跑--方法
    public void run(){
        System.out.println(this.color+"颜色的"+this.brand+this.size+"小汽车可以驰骋，跑的嗷嗷快");
        //调用车轮子的方法      轮子对象.轮子方法();
        for(int i=0;i<wheels.length;i++){
            Wheel wheel = wheels[i];
            wheel.round();
        }
    }

}
