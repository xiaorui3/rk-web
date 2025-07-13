package 斗地主;

import java.util.*;

public class Game {
    //{1=♣3, 2=♣4, 3=♣5, 4=♣6, 5=♣7, 6=♣8, 7=♣9, 8=♣10, 9=♣J, 10=♣Q, 11=♣K, 12=♣A, 13=♣2,
    // 14=♦3, 15=♦4, 16=♦5, 17=♦6, 18=♦7, 19=♦8, 20=♦9, 21=♦10, 22=♦J, 23=♦Q, 24=♦K, 25=♦A, 26=♦2,
    // 27=♥3, 28=♥4, 29=♥5, 30=♥6, 31=♥7, 32=♥8, 33=♥9, 34=♥10, 35=♥J, 36=♥Q, 37=♥K, 38=♥A, 39=♥2,
    // 40=♠3, 41=♠4, 42=♠5, 43=♠6, 44=♠7, 45=♠8, 46=♠9, 47=♠10, 48=♠J, 49=♠Q, 50=♠K, 51=♠A, 52=♠2,
    // 53=小王, 54=大王}
    static HashMap<Integer,String> map=new HashMap<>();
    static ArrayList<String> list=new ArrayList<>();
    static ArrayList<Integer> arr=new ArrayList<>();
    static {
        //准备
        String[] color={"♣","♦","♥","♠"};
        String[] number={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        int i=1;
        for (String s1 : number) {
            for (String s : color) {
                arr.add(i);
                map.put(i,s+s1);i++;
                list.add(s+s1);
            }
        }
        map.put(i++,"小王");arr.add(i);
        map.put(i,"大王");arr.add(i);
        list.add("小王");
        list.add("大王");
    }
    public Game(){
        System.out.println(map);
        //洗牌
        Collections.shuffle(list);
        //发牌
        ArrayList<String> lord=new ArrayList<>();
        ArrayList<String> play1=new ArrayList<>();
        ArrayList<String> play2=new ArrayList<>();
        ArrayList<String> play3=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            if(i<=2){
                lord.add(poker);
                continue;
            }
            if(i%3==0){
                play1.add(poker);
            } else if (i%3==1) {
                play2.add(poker);
            } else {
                play3.add(poker);
            }
        }
        //看牌
        lookpoker("底牌",lord);
        lookpoker("小锐",play1);
        lookpoker("张三",play2);
        lookpoker("李四",play3);
    }
    public void lookpoker(String name,ArrayList<String> list){
        System.out.print(name+":");
        for (String s : list) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
    public void pokerlist(ArrayList<String> list){

    }
}
