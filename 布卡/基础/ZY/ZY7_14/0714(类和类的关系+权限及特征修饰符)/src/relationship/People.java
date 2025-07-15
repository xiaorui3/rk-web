package relationship;

public class People {

    //有名字
    public String name;

    public People(){}
    public People(String name){
        this.name = name;
    }

    //人用电脑的方法
        //条件，有一台电脑才能用吧      参数
    public void useComputer(Computer computer){     //依赖关系
        System.out.println(this.name+"用上电脑啦");
        System.out.println(computer.brand+"--"+computer.color);
        computer.beUsed();
    }

    public void eat(){
        System.out.println("吃饭的方法");
    }



}
