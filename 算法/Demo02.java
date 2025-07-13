package 算法;

public class Demo02 {
    public static void main(String[] args) {
        int count=0;
        for(int i=1;i<=100;i++){
            for(int j=1;j<=i;j++){
                for(int k=1;k<=j;k++){
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(100*(100+1)*(100+2)/6);
    }
}
