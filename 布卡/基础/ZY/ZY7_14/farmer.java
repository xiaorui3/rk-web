package 布卡.基础.ZY.ZY7_14;

public class farmer extends person{
    public farmer(){

    }
    public farmer(int age,String name){
        this.setAge(age);
        this.setName(name);
    }
    @Override
    public void eat(){
        System.out.println("农夫在吃饭"+this.getName()+"  "+this.getAge());
    }
    public void TillLand(String goods){
        System.out.println("农夫在种"+goods+this.getName()+"  "+this.getAge());
    }
     
    
    public void plantSoybean() {
        soybean soy = new soybean();
        for (int i = 0; i < 90; i++) {
            soy.grow();
        }
        if (soy.isMature()) {
            System.out.println("大豆成熟了");
        }
    }
    
    public void raisePig(Pig pig) {
        while (pig.getWeight() < 100) {
            pig.gainWeight();
        }
        System.out.println(pig.getName() + " 长到了 100 斤");
    }
    public void feedPigWithSoybean(Pig pig) {
        soybean soy = new soybean();
        for (int i = 0; i < 90; i++) {
            soy.grow();
        }
        if (soy.isMature()) {
            String food = soy.getFoodForPig();
            pig.eat(food);
        }
    }
}
