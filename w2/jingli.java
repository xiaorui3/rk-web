public class jingli extends ren {
    private String gongzuo;
    private double jiangjin;
    public jingli(){
        super();
    }
    public void guanli(){
        
        System.out.println("管理");
    }
    @Override
    public void gongzuo1(){
        System.out.println("管理其他人");
    }
    public String getGongzuo() {
        return gongzuo;
    }
    public void setGongzuo(String gongzuo) {
        this.gongzuo = gongzuo;
    }
    public double getJiangjin() {
        return jiangjin;
    }
    public void setJiangjin(double jiangjin) {
        this.jiangjin = jiangjin;
    }
    public jingli(String gongzuo, double jiangjin) {
        this.gongzuo = gongzuo;
        this.jiangjin = jiangjin;
    }
    public jingli(String hao, String name, int gonfzi, String gongzuo, double jiangjin) {
        super(hao, name, gonfzi);
        this.gongzuo = gongzuo;
        this.jiangjin = jiangjin;
    }
}
