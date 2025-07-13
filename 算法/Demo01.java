package 算法;

public class Demo01 {
    public static void main(String[] args) {
        int count=2000;
        int sum=0;
        for(;count<=2060;count++){
            if((count%4==0&&count%100!=0)||count%400==0){
                sum++;
                System.out.printf("%d是闰年\n",count);
            }
        }
    }
}
