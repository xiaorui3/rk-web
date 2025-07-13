package 算法;

public class 月份  {
    static int[] w={0,31,28,31,30,31,30,31,31,30,31,30,31};
    static int y=1900,m=1,d=1;
    public static void main(String[] args) {
        while(y!=9999||m!=12||d!=31){//截止日期
            if(y%400==0||y%4==0&&y%100!=0){//判断闰年
                w[2]=29;
            }else{
                w[2]=28;
            }
            d++;
            if(d>w[m]) {
                d = 1;
                m++;
            }
            if(m>12){
                m=1;
                y++;
            }
            System.out.println(y+"年"+m+"月"+d+"日");
        }
    }
}
