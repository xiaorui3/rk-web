package computer;

public class Student {

    private String name;
    private int RP = (int)(Math.random()*10)+1; //1-10

    public Student(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    //使用电脑的方法
    public void useComputer(Computer computer){
        System.out.println(this.name+"开始用电脑啦");
        computer.beOpen();
        computer.beUsing();
        if(this.RP>5){
            computer.beClose();
        }else{
            System.out.println(this.name+"RP有问题，没关电脑");
        }
    }
}
