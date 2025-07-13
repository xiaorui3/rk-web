package 斗地主;

import java.util.*;

public class Game1 {
        //{1=♣3, 2=♣4, 3=♣5, 4=♣6, 5=♣7, 6=♣8, 7=♣9, 8=♣10, 9=♣J, 10=♣Q, 11=♣K, 12=♣A, 13=♣2,
        // 14=♦3, 15=♦4, 16=♦5, 17=♦6, 18=♦7, 19=♦8, 20=♦9, 21=♦10, 22=♦J, 23=♦Q, 24=♦K, 25=♦A, 26=♦2,
        // 27=♥3, 28=♥4, 29=♥5, 30=♥6, 31=♥7, 32=♥8, 33=♥9, 34=♥10, 35=♥J, 36=♥Q, 37=♥K, 38=♥A, 39=♥2,
        // 40=♠3, 41=♠4, 42=♠5, 43=♠6, 44=♠7, 45=♠8, 46=♠9, 47=♠10, 48=♠J, 49=♠Q, 50=♠K, 51=♠A, 52=♠2,
        // 53=小王, 54=大王}
        static HashMap<Integer, String> map = new HashMap<>();
        static ArrayList<Integer> arr = new ArrayList<>();

        static {
            //准备
            String[] color = {"♣", "♦", "♥", "♠"};
            String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
            int i = 1;
            for (String s1 : number) {
                for (String s : color) {
                    arr.add(i);
                    map.put(i, s + s1);
                    i++;
                }
            }
            map.put(i, "小王");
            arr.add(i);
            i++;
            map.put(i, "大王");
            arr.add(i);
        }
    public Game1(){
        Collections.shuffle(arr);
        TreeSet<Integer> lord =new TreeSet<>();
        TreeSet<Integer> play1=new TreeSet<>();
        TreeSet<Integer> play2=new TreeSet<>();
        TreeSet<Integer> play3=new TreeSet<>();
        for (int i = 0; i < arr.size(); i++) {
            Integer poker = arr.get(i);
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
        lookpoker("底牌",lord);
        lookpoker("小锐",play1);
        lookpoker("张三",play2);
        lookpoker("李四",play3);
    }
    public void lookpoker(String name,TreeSet<Integer> list){
        System.out.print(name+":");
        for (int s : list) {
            String s1 = map.get(s);
            System.out.print(s1+" ");
            }
        System.out.println();
    }
}
