package kill;

//屠夫
public class Butcher {

    //方法----杀猪
    //  参数？---猪     返回值？
    public void killPig(Pig pig){           //依赖
        //猪被杀了
        //1.看看猪的体重      60斤
        int pigWeight = pig.getWeight();
        System.out.println(pig.getName()+"体重是："+pigWeight);
        if(pigWeight>60){
            pig.beKilled();
        }else{
            System.out.println("换一头");
        }
    }

}
