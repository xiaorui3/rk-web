package 布卡.基础.ZY.ZY7_11;

public class test3 {
    public static void main(String[] args) {

        int sum=0;
        for (;sum<370;sum++){
            if (sum-10==sum+20  &&  sum/2==sum*2){
                if (sum-10==sum/2){
                    System.out.println(sum+10);
                    System.out.println(sum-20);
                    System.out.println(sum*2);
                    System.out.println(sum/2);
                }

            }
        }




        //for (int j=0;j<=370;j++){
        //    for (int y=0;y<=370;y++){
        //        for (int b=0;b<=370;b++){
        //            for (int d=0;d<=370;d++){
        //                if(j+10==y-20){
        //                    if (b*2==d/2){
        //                        if (j+10==b*2 && j+y+b+d==370){
        //                            System.out.println(j);
        //                            System.out.println(y);
        //                            System.out.println(b);
        //                            System.out.println(d);
        //                        }
        //                    }
        //                }
        //            }
        //        }
        //    }
        //}
    }
}
