package 布卡.基础.ZY.ZY8_02.抢红包线程锁;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class WxQun {
    private static final int Person=100;
    private static Vector<WxUser> v =new Vector<>(Person);
    private static final WX wx = new WX();
    private static double v1;
    public static List<Double> doubles;
    public static void main(String[] args) {
        for (int i = 0; i <Person ; i++) {
            String name="王"+(i+1);
            int id=i;
            //System.out.println(name+"  "+id);
            v.add(new WxUser(name,id));
        }

        System.out.println(v);

        System.out.println("请输入您要发送的红包：");
        Scanner sc =new Scanner(System.in);
        v1 = sc.nextDouble();
        doubles= wx.hongBao(v1, Person);
        for(WxUser vp :v){
            new Thread(vp).start();
        }

    }
}
