package w3;

public class dog extends dongwu {
    public dog(int age, String yanse){
        super(age,yanse);
    }
    @Override
    public void eat(String shiwu){
        System.out.println("年龄为"+age+"狗在吃"+shiwu);
    }
    
    public void kanjia(){
        System.out.println("狗在看家");
    }
}
