public class dog extends catdog {
    String name;
    String kanjia;
    String xingwei;
    public String getKanjia() {
        return kanjia;
    }
    public void setKanjia(String kanjia) {
        this.kanjia = kanjia;
    }
    public String getXingwei() {
        return xingwei;
    }
    public void setXingwei(String xingwei) {
        this.xingwei = xingwei;
    }
    public dog(String name, String kanjia, String xingwei) {
        this.name=name;
        this.kanjia = kanjia;
        this.xingwei = xingwei;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void printf(){
        System.out.println(getName()+" "+getChifan()+" "+getHeshui()+" "+getKanjia()+" "+getXingwei());
    }
}
