package w9;

/**
 * @author zhaorui
 */
public class aq1 {
    public static void main(String[] args) {
        long kaishi=System.currentTimeMillis();
        for(long i=1;i<2000000;i++){
            long k=jisuan(i);
            long m=i;
            double a=0;
            while(m!=0){
                long p=m%10;
                a=a+Math.pow(p,k);

                m=m/10;
            }
            if(a==i){
                System.out.println(i);
            }
        }
        long jieshu=System.currentTimeMillis();
        long p=jieshu-kaishi;
        System.out.println("时间="+p);
    }
    public static long jisuan(long a){
        long i=0;
        while(a!=0){
            i++;
            a=a/10;
        }
        return i;
    }
}
