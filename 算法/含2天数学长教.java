package 算法;

public class 含2天数学长教 {
    static int[] w={0,31,28,31,30,31,30,31,31,30,31,30,31};
    static int y=1900,m=1,d=1;
    public static void main(String[] args) {
        long ans=0;
        while(y!=9999||m!=12||d!=31){
            if(y%400==0||y%4==0&&y%100!=0){
                w[2]=29;
            }else{
                w[2]=28;
            }
            if (cha()) {
                ans++;
            }
            d++;
            if(d>w[m]){
                m++;d=1;
            }
            if(m>12){
                m=1;y++;
            }
        }
        System.out.println(++ans);
    }
    public static boolean cha(){
        int a=y,b=m,c=d;
        while(a>0){
            if(a%10==2){
                return true;
            }
            a=a/10;
        }
        while(b>0){
            if(b%10==2){
                return true;
            }
            b=b/10;
        }
        while (c>0){
            if(c%10==2){
                return true;
            }
            c=c/10;
        }
        return false;
    }
}
