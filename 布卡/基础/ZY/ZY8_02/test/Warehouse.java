package 布卡.基础.ZY.ZY8_02.test;

import java.util.ArrayList;

//仓库
public class Warehouse {

    //唯一的：单例    保证传递给生产者和消费者的仓库对象是同一个

    //容器：集合ArrayList
    private ArrayList<String> list = new ArrayList<>();
    {
        for(int i=1;i<=5;i++){
            list.add("a");
        }
    }

    //认为，集合的长度超过20个，暂时填满啦

    public synchronized void add(){
        if(list.size()<20){
            list.add("a");
        }else{
            try {
                this.notifyAll();
                this.wait();        //仓库.wait();    生产者等会儿
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void get(){
        if(list.size()>0){
            list.remove(0);
        }else{
            try {
                this.notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
