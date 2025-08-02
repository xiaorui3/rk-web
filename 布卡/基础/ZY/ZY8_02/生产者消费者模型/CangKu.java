package 布卡.基础.ZY.ZY8_02.生产者消费者模型;

import java.util.ArrayList;

public class CangKu {
    ArrayList<String> list = new ArrayList<>();
    private final static int size=30;
    {
        for (int i = 0; i < 5; i++) {
            list.add("a");
        }
    }

    public void add(){
        if (list.size()<CangKu.size){
            if (list.size()<5){
                this.list.add("a");
            }else{
                this.list.add("b");
            }
        }else{
            this.notifyAll();
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void get(){
        if (!list.isEmpty()){
            list.remove(0);
        }else{
            this.notifyAll();
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
