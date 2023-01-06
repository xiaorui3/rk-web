public class main1 {
    public static void main(String[] args) {
        cat w1=new cat("布偶猫","抓老鼠");
        cat w2=new cat("中国狸花猫","抓老鼠");
        dog q1=new dog("哈士奇", "看家","拆家");
        dog q2=new dog("泰迪","看家","蹭一蹭");
        w1.catdog1("吃饭","喝水");
        w2.catdog1("吃饭","喝水");
        q1.catdog1("吃饭","喝水");
        q2.catdog1("吃饭","喝水");
        w1.printf();
        w2.printf();
        q1.printf();
        q2.printf();
    }
}
