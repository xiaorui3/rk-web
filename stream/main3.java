package stream;

public class main3 {
    public static void main(String[] args) {
        int count = 0;
        System.out.print("水仙花数有：");
        for(int i=100; i<=999; i++){
            int one = i % 10;
            int ten = i / 10 % 10;
            int hundred = i / 100 % 10;
            if(Math.pow(one,3) + Math.pow(ten,3) + Math.pow(hundred,3) == i){
                System.out.print(i+" ");
                count++;
            }
        }
        System.out.println();
        System.out.println("一共"+count+"个");
    }
}
