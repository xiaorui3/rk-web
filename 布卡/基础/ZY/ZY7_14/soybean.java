package 布卡.基础.ZY.ZY7_14;

public class soybean extends vegetable {
    private String name;
    private boolean isMature = false;
    private int growthDays = 0;

    public soybean() {
        this.name = "大豆";
    }

    public String getName() {
        return name;
    }

    public void plant() {
        System.out.println(name + " 被种下了");
    }

    public void grow() {
        growthDays++;
        System.out.println(name + " 生长了一天，已生长 " + growthDays + " 天");
        if (growthDays >= 90) {
            isMature = true;
        }
    }

    public boolean isMature() {
        return isMature;
    }

    public void ripe() {
        if (isMature) {
            System.out.println(name + " 成熟了");
        } else {
            System.out.println(name + " 还未成熟");
        }
    }

    public String getFoodForPig() {
        if (isMature) {
            return "大豆饲料";
        }
        return "未成熟大豆";
    }
}
