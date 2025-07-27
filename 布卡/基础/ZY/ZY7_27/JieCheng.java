package 布卡.基础.ZY.ZY7_27;

public class JieCheng {
    public static void main(String[] args) {
        System.out.println(new JieCheng().Jie(5));
    }
    public int Jie(int ppp){
        return ppp!=0?ppp*Jie(ppp-1):1;
    }
}
