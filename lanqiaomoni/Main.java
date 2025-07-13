package lanqiaomoni;

public class Main {
    public static void main(String[] args) {

    }
}
class shangpin{
    private String name;
    private float jiage;
    private String zheko;

    public shangpin() {
    }

    public shangpin(String name, float jiage, String zheko) {
        this.name = name;
        this.jiage = jiage;
        this.zheko = zheko;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return jiage
     */
    public float getJiage() {
        return jiage;
    }

    /**
     * 设置
     * @param jiage
     */
    public void setJiage(float jiage) {
        this.jiage = jiage;
    }

    /**
     * 获取
     * @return zheko
     */
    public String getZheko() {
        return zheko;
    }

    /**
     * 设置
     * @param zheko
     */
    public void setZheko(String zheko) {

        this.zheko = zheko;
    }

    public String toString() {
        return "shangpin{name = " + name + ", jiage = " + jiage + ", zheko = " + zheko + "}";
    }
}
