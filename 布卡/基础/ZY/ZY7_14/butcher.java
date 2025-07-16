package 布卡.基础.ZY.ZY7_14;

public class butcher extends person {
    public butcher() {
    }

    public butcher(int age, String name) {
        this.setAge(age);
        this.setName(name);
    }

    public void killPig(Pig pig) {
        System.out.println(this.getName() + " 宰杀了 " + pig.getName());
    }

    public void showPigWeight(Pig pig) {
        System.out.println(pig.getName() + " 的重量为 " + pig.getWeight() + " 斤");
    }
}