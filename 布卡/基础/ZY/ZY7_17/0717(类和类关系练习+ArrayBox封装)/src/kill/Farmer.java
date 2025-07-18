package kill;

//农夫
public class Farmer {

    private String name;

    public Farmer(String name){
        this.name = name;
    }

    //方法-----养猪
    //  是否需要条件，是否需要结果----猪
    public Pig yangPig(int day){
//        Pig pig = new Pig();            //依赖
//        pig.setName("小花");
        Pig pig = new Pig("小花");

        System.out.println(this.name+"养了一头猪，名字叫："+pig.getName());
        //猪长大   循环5次
        pig.growUp(day);

        return pig;
    }

}
