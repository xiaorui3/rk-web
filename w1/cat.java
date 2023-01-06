public class cat extends catdog {
    String xingwei;
    String name;
    public String getXingwei() {
        return xingwei;
    }

    public void setXingwei( String xingwei) {
        this.xingwei = xingwei;
    }

    public cat(String name,String xingwei) {
        this.name=name;
        this.xingwei = xingwei;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void printf(){
        System.out.println(getName()+" "+getChifan()+" "+getHeshui()+" "+" "+getXingwei());
    }
    
}
