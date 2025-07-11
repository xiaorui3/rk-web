package 布卡.基础.ZY.ZY7_11;

public class 三角 {
    public static void main(String[] args) {
        //1
        for (int i=1;i<=4;i++){
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //2
        for (int i=1;i<=4;i++){
            int m=0;
            for (int j=4;j>=1;j--){
                if (j==i){
                    System.out.print("*");
                    m=1;
                }else{
                    if (m==1){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

        //3
        for (int i=1;i<=4;i++){
            for (int j=0;j<4-i;j++){
                System.out.print(" ");
            }
            for (int j=0;j<2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //4
        for (int i=1;i<=4;i++){
            for (int j=0;j<4-i;j++){
                System.out.print(" ");
            }
            for (int j=0;j<i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        //5
        int k=1;
        int p=1;
        for (int i=4;i>=1;i--){
            if (i==4){
                for (int j=2*i-1;j>0;j--){
                    System.out.print("*");
                }
            }
            else{
                for (int j=i;j>0;j--){
                    System.out.print("*");
                }
                for (int j=p;j>0;j--){//3----1  2----3  1-----5
                    System.out.print(" ");
                }
                k++;
                p=2*k-1;
                for (int j=i;j>0;j--){
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        //6
        for (int i=1;i<=4;i++){
            for (int j=0;j<4-i;j++){
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++){
                System.out.print(j);
            }
            for (int l=i-1;l>0;l--){
                System.out.print(l);
            }
            System.out.println();
        }


        //7
        for (int i=1;i<=9;i++){
            for (int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+i*j+" ");
            }
            System.out.println();
        }

        //8
        for (int i=2;i<=100;i++){
            int j=2;
            for (;j<=i;j++){
                if (i%j==0){
                    break;
                }
            }
            if (j==i){
                System.out.println(i+"是素数");
            }else{
                System.out.println(i+"不是素数");
            }

        }


    }
}
