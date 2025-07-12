package 布卡.基础.ZY.ZY7_12;

import java.util.Arrays;
import java.util.Scanner;

public class BkUiltZr {
    public static int zy01(int a,int b){
        int sum = a++ + ++b - --a + --b + a-- - --b;
        System.out.println("经过a++ + ++b - --a + --b + a-- - --b运算  结果为："+sum);
        return sum;
    }
    public static void zy02(int a,int b){
        int c,d;
        c=a---b;
        d=a---b;
        System.out.println(c);
        System.out.println(b);
    }
    public static void zy03(int x){
        boolean b1 = true;
        boolean b2 = false;
        if( (x==4) && !b2 )
            System.out.print("1 ");
        System.out.print("2 ");
        if( (b2=true) && b1)
            System.out.print("3");
    }

    public static void zy04(int a){
        while(a<5){
            switch(a){
                case 0:
                case 3:  a=a+2;
                case 1:
                case 2:  a=a+3;
                default: a=a+5;
            }
        }
        System.out.println(a);
    }
    public static void zy05(){
        System.out.println("请输入一个数字");
        Scanner sc =new Scanner(System.in);
        int score=sc.nextInt();
        if (score==100){
            System.out.println("满分");
        }else if(score>=90 && score<100){
            System.out.println("优秀");
        }else if(score>=80 && score<90){
            System.out.println("良好");
        }else if(score>=70 && score<80){
            System.out.println("中等");
        }else if(score>=60 && score<70){
            System.out.println("及格");
        }else if(score>=0 && score<60){
            System.out.println("不及格");
        }else{
            System.out.println("输入错误");
        }
    }
    public static void zy06(){
        Scanner sc =new Scanner(System.in);
        int day=sc.nextInt();
        if (day>=1 && day<=5){
            System.out.println("工作日");
        }else if(day==6 || day==7){
            System.out.println("休息日");
        }else{
            System.out.println("输入错误");
        }
    }
    public static void zy07(){
        System.out.println("请输入一个数字");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        switch (score / 10) {
            case 10:
                System.out.println("优秀");
                break;
            case 9:
                System.out.println("优秀");
                break;
            case 8:
                System.out.println("良好");
                break;
            case 7:
                System.out.println("中等");
                break;
            case 6:
                System.out.println("及格");
                break;
            default:
                if (score >= 0 && score < 60) {
                    System.out.println("不及格");
                } else {
                    System.out.println("输入错误");
                }
        }


        int day = sc.nextInt();

        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("工作日");
                break;
            case 6:
            case 7:
                System.out.println("休息日");
                break;
            default:
                System.out.println("输入错误");
        }
    }
    public static void zy08(){
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
    public static void zy09(){
        int[] arr1={1,2,3,4,5,6,7,8,9};
        int sum=0;
        for(int i=0;i<arr1.length/2;i++){
            sum=arr1[i];
            arr1[i]=arr1[arr1.length-1-i];
            arr1[arr1.length-1-i]=sum;
        }
        System.out.println(Arrays.toString(arr1));
    }
    public static void zy10(){
        int[] arr ={1,3,5,7,9,8,6,4,2};
        int max=0;
        int min=100000000;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]>max){
                max=arr[i];
            }
            if (arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("最大值为："+max);
        System.out.println("最小值为："+min);
    }
    public static void zy11(){
        int[] arr1={1,3,2};
        int[] arr2={5,4};
        int[] arr3=new int[arr1.length+arr2.length];
        for (int i = 0; i < arr3.length; i++){
            if (i<arr1.length){
                arr3[i]=arr1[i];
            }else if(i-arr1.length<arr2.length){
                arr3[i]=arr2[i-arr1.length];
            }

        }
        System.out.println(Arrays.toString(arr3));
    }
    public static void zy12(){
        int[] arr = {1, 2, 3, 9, 4, 5};
        //将数组按照最大值的位置拆分	---->	{1,2,3}	{4,5}
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("最大值为：" + max);
        int[] arr1 = null;
        int[] arr2 = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr1 = new int[i];
                arr2 = new int[arr.length - i - 1];
                for (int j = 0; j < i; j++) {
                    arr1[j] = arr[j];
                }
                for (int j = i + 1; j < arr.length; j++) {
                    arr2[j - i - 1] = arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    public static void zy13(){
        int[] arr={1,3,5,7,9,0,2,4,0,6,0,8,7,0,1};
        int m=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                m++;
            }
        }
        int[] arr1=new int[arr.length-m];
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0){
                arr1[j++]=arr[i];
            }

        }
        System.out.println(Arrays.toString(arr1));
    }
    public static void zy14(){
        int p=0;
        int[] arr =new int[100];
        for (int i=2;i<=100;i++){
            int j=2;
            for (;j<=i;j++){
                if (i%j==0){
                    break;
                }
            }
            if (j==i){
                //System.out.println(i+"是素数");
                arr[p++]=i;

            }else{
                //System.out.println(i+"不是素数");
            }

        }
        int[] arrL=new int[p];
        for (int i=0;i<p;i++){
            arrL[i]=arr[i];
        }
        System.out.println(Arrays.toString(arrL));
    }
    public static void zy15(){
        int[] arr1={1,2,5,6,8};
        int[] arr2={1,3,4,5,6,9};
        int[] arr3=new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while (i<arr1.length&&j<arr2.length){
            if (arr1[i]<arr2[j]){
                arr3[k]=arr1[i];
                i++;
            }else {
                arr3[k]=arr2[j];
                j++;
            }
            k++;
        }
        while (i<arr1.length){
            arr3[k]=arr1[i];
            i++;
            k++;
        }
        while (j<arr2.length){
            arr3[k]=arr2[j];
            j++;
            k++;
        }
        for (int i1 = 0; i1 < arr3.length; i1++) {
            System.out.print(arr3[i1]+" ");
        }
        System.out.println();
    }
    public static void zy16(){
        String[] users={"zhangsan","lisi","wangwu","zhaoliu"};
        String[] pwds={"333","444","555","666"};


        //Client:
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name=sc.next();
        System.out.println("请输入密码：");
        String pwd=sc.next();

        boolean flagName=false;
        boolean flagPwd=false;
        for(int i=0;i<users.length;i++){
            if(name.equals(users[i])){
                if (pwd.equals(pwds[i])){
                    //System.out.println("登录成功");
                    flagName=true;
                    flagPwd=true;
                    break;
                }else{
                    //System.out.println("密码错误");
                    flagName=true;
                }
            }else{
                //System.out.println("用户名不存在");

            }
        }
        if (flagName){
            if (flagPwd){
                System.out.println("登录成功");
            }else{
                System.out.println("密码错误");
            }
        }else{
            System.out.println("用户名不存在");
        }
    }
    public static void zy17(){
        //1
        for (int i=1;i<=4;i++){
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //2
        for (int i=1;i<=4;i++){
            int m=0;
            for (int j=4;j>=1;j--){
                if (j==i){
                    System.out.print("*");
                    m=1;
                }else{
                    if (m==1){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

        //3
        for (int i=1;i<=4;i++){
            for (int j=0;j<4-i;j++){
                System.out.print(" ");
            }
            for (int j=0;j<2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //4
        for (int i=1;i<=4;i++){
            for (int j=0;j<4-i;j++){
                System.out.print(" ");
            }
            for (int j=0;j<i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        //5
        int k=1;
        int p=1;
        for (int i=4;i>=1;i--){
            if (i==4){
                for (int j=2*i-1;j>0;j--){
                    System.out.print("*");
                }
            }
            else{
                for (int j=i;j>0;j--){
                    System.out.print("*");
                }
                for (int j=p;j>0;j--){//3----1  2----3  1-----5
                    System.out.print(" ");
                }
                k++;
                p=2*k-1;
                for (int j=i;j>0;j--){
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        //6
        for (int i=1;i<=4;i++){
            for (int j=0;j<4-i;j++){
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++){
                System.out.print(j);
            }
            for (int l=i-1;l>0;l--){
                System.out.print(l);
            }
            System.out.println();
        }


        //7
        for (int i=1;i<=9;i++){
            for (int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+i*j+" ");
            }
            System.out.println();
        }

        //8
        for (int i=2;i<=100;i++){
            int j=2;
            for (;j<=i;j++){
                if (i%j==0){
                    break;
                }
            }
            if (j==i){
                System.out.println(i+"是素数");
            }else{
                System.out.println(i+"不是素数");
            }
        }
    }
}
