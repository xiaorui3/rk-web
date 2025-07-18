package computer;

//这是机房
public class Room {

    //有一台电脑
//    private Computer computer = new Computer(1);

    //有五台电脑     统一管理起来      数组          电脑[]
    private Computer[] computers = new Computer[5];

    //构建room对象的时候，认为电脑就应该初始化，room的构造方法里
    {
        for(int i=0;i<computers.length;i++){
            computers[i] = new Computer(i+1);
        }
    }

    //方法，机房开门，等待学生进来用
    public void open(Student student){
        System.out.println(student.getName()+"进入了机房");

        //找关闭的电脑用？？？
        for(int i=0;i< computers.length;i++){
            Computer c = computers[i];
            if(!c.isUsed()){
                student.useComputer(c);
                break;
            }
        }
    }

}
