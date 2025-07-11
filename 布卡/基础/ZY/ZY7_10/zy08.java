package 布卡.基础.ZY.ZY7_10;

import java.util.Scanner;

public class zy08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请选择模式：1. 单个骰子  2. 三个骰子");
        int mode = sc.nextInt();

        System.out.println("DeBug模式（开局看到点数）：1. 开启  2. 关闭");
        int mode1 = sc.nextInt();



        int totalPoints = 0;
        boolean allSame = false;

        if (mode == 1) {
            int dice = (int) (Math.random() * 6 + 1);
            if (mode1==1){
                System.out.println("骰子点数：" + dice);
            }
            System.out.println("请输入你的猜测（买大/买小/具体数字）");
            String guess = sc.next();
            if (guess.equals("买大") && dice >= 4) {
                System.out.println("恭喜猜对！你赢了！");
                System.out.println("骰子点数：" + dice);
            } else if (guess.equals("买小") && dice <= 3) {
                System.out.println("恭喜猜对！你赢了！");
                System.out.println("骰子点数：" + dice);
            } else if (guess.matches("\\d+") && Integer.parseInt(guess) == dice) {
                System.out.println("恭喜猜中点数！你赢了！");
                System.out.println("骰子点数：" + dice);
            } else {
                System.out.println("很遗憾，猜错了！");
                System.out.println("骰子点数：" + dice);
            }

        } else if (mode == 2) {
            int d1 = (int) (Math.random() * 6 + 1);
            int d2 = (int) (Math.random() * 6 + 1);
            int d3 = (int) (Math.random() * 6 + 1);
            totalPoints = d1 + d2 + d3;
            allSame = d1 == d2 && d2 == d3;

            if(mode1==1){
                System.out.println("三个骰子分别为：" + d1 + " " + d2 + " " + d3);
                System.out.println("总点数：" + totalPoints);
            }
            System.out.println("请输入你的猜测（买大/买小/具体数字）");
            String guess = sc.next();
            if (allSame) {

                System.out.println("通杀！你输了！");
                System.out.println("三个骰子分别为：" + d1 + " " + d2 + " " + d3);
                System.out.println("总点数：" + totalPoints);
            } else if (guess.equals("买大") && totalPoints >= 9) {
                System.out.println("恭喜猜对！你赢了！");
                System.out.println("三个骰子分别为：" + d1 + " " + d2 + " " + d3);
                System.out.println("总点数：" + totalPoints);
            } else if (guess.equals("买小") && totalPoints < 9) {
                System.out.println("恭喜猜对！你赢了！");
                System.out.println("三个骰子分别为：" + d1 + " " + d2 + " " + d3);
                System.out.println("总点数：" + totalPoints);
            } else {
                System.out.println("很遗憾，猜错了！");
                System.out.println("三个骰子分别为：" + d1 + " " + d2 + " " + d3);
                System.out.println("总点数：" + totalPoints);
            }
        } else {
            System.out.println("无效模式！");

        }

        sc.close();
    }
}
