package 算法;

public class 完全日期 {
    static int[] w={0,31,28,31,30,31,30,31,31,30,31,30,31};
    static int y=2001,m=1,d=1;
    public static void main(String[] args) {
        int aus=0;
        while(y!=2021||m!=12||d!=31){
            if(date()){
                aus++;
            }
            d++;
            if(d>w[m]){
                d=1;
                m++;
            }
            if(m>12){
                m=1;
                y++;
            }
        }
        if(date()){
            aus++;
        }
        System.out.println(aus);
    }
    public static boolean date(){
        int a=y,b=m,c=d;
        int sum=0;
        while(a>0){
            sum=sum+a%10;
            a=a/10;
        }
        while(b>0){
            sum=sum+b%10;
            b=b/10;
        }
        while(c>0){
            sum=sum+c%10;
            c=c/10;
        }
        return sum == 16;
    }
}
