package 时间;

public class main4 {
    String name;
    String sheng;

    public main4() {
    }

    public main4(String name, String sheng) {
        this.name = name;
        this.sheng = sheng;
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
     * @return sheng
     */
    public String getSheng() {
        return sheng;
    }

    /**
     * 设置
     * @param sheng
     */
    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String toString() {
        return "main4{name = " + name + ", sheng = " + sheng + "}";
    }
}
