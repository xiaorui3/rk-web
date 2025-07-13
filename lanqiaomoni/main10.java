package lanqiaomoni;

public class main10 {
    public static void main(String[] args) {
        int cou=0;
        for(int i=1;i<=2020;i++){
            for(int j=1;j<=2020;j++){
                if(yue(i,j)){
                    cou++;
                }
            }
        }
        System.out.println(cou);
    }
    public static boolean yue(int x,int y){
        int z = y;
        while(x%y!=0)
        {
            z = x%y;
            x = y;
            y = z;
        }
        return z==1;
    }
}
