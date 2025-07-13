package w3;

public class main1 {
    public static void main(String[] args) {
        ren r1=new ren("老王","30","骨头");
        ren r2=new ren("老李","34","小鱼干");
        dongwu d1=new dog(4,"黑色");
        dongwu d2=new cat(5,"黄色");
        r1.xingwei(d1, r1.shiwu);
        r2.xingwei(d2, r2.shiwu);
    }
}
