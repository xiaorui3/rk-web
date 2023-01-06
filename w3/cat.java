package w3;
public class cat extends dongwu {
    public cat(int age, String yanse){
        super(age,yanse);
    }
    public void zhuo(){
        System.out.println("猫在捉老鼠");
    }
    @Override
    public void eat(String shiwu){
        System.out.println("年龄为"+age+"猫在吃"+shiwu);
    }
}
