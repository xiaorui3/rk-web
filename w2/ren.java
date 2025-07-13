public class ren {
    private String hao;
    private String name;
    private int gonfzi;
    public ren(){

    }
    public void chi(){
        System.out.println("吃米饭");
    }
    public String getHao() {
        return hao;
    }
    public void setHao(String hao) {
        this.hao = hao;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGonfzi() {
        return gonfzi;
    }
    public void setGonfzi(int gonfzi) {
        this.gonfzi = gonfzi;
    }
    public ren(String hao, String name, int gonfzi) {
        this.hao = hao;
        this.name = name;
        this.gonfzi = gonfzi;
    }
    public void gongzuo1(){
        System.out.println("员工在工作");
    }
}
