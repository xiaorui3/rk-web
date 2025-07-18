package kill;

//猪
public class Pig {

    //属性
    private String name;//名字
    private int weight = 2;//体重

    //属性----猪的体质    1-10
    private int flag = (int)(Math.random()*10)+1;



    public Pig(){}
    public Pig(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return this.weight;
    }

    //方法
    //  用来描述猪长肉     参数？养猪的天数，长大的算法2倍       返回值？
    public void growUp(int day){            //int day,饲料 大豆
        if(this.flag>5){
            for(int i=1;i<=day;i++) {
                this.weight *= 2;           //64
                System.out.println("第"+i+"几天"+this.name+"体重是"+this.weight);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }else{
            for(int i=1;i<=day;i++) {
                this.weight += 2;           //12
                System.out.println("第"+i+"几天"+this.name+"体重是"+this.weight);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //用来描述，猪被杀了
    public void beKilled(){
        System.out.println(this.name+"被杀啦，好惨~~~");
    }

}
