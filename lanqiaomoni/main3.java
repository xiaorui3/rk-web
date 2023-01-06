package lanqiaomoni;

public class main3 {
    public static void main(String[] args) {
        int a=2,arr=0;
        for(int i=0;i<=2020;i++){
            if(i==a){
                arr++;
            }
            int k=i;
            if(k>=10){
                while(k!=0){
                    if(k%10==a){
                        arr++;
                    }
                    k=k/10;
                }
            }
        }
        System.out.println(arr);
    }
}
