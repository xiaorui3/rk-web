package 布卡.基础.ZY.ZY7_11;

public class test {
    public static void main(String[] args) {
        int jiao=160;
        int to=50;
        for (int ji=0;ji<to;ji++){
            int tu=to-ji;
            if (ji*2+tu*4==jiao){
                System.out.println(ji);
                System.out.println(tu);
            }
        }

    }
}
