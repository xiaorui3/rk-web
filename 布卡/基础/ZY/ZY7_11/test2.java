package 布卡.基础.ZY.ZY7_11;

public class test2 {
    public static void main(String[] args) {
        int i=100;
        for (;i<=999;i++){
            int g=i%10;
            int s=(i/10)%10;
            int b=i/100;
            if(g*g*g+s*s*s+b*b*b==i){
                System.out.println(i);
            }
        }
    }
}
