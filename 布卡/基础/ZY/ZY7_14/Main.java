package 布卡.基础.ZY.ZY7_14;

public class Main {
    public static void main(String[] args) {
        farmer farmer = new farmer(30, "张农夫");
        farmer.eat();
        farmer.TillLand("大豆");

        farmer.plantSoybean();

        Pig pig = new Pig("小黑", "黑猪", 1, 50.0);

        farmer.raisePig(pig);

        farmer.feedPigWithSoybean(pig);

        butcher butcher = new butcher(40, "李屠夫");

        butcher.showPigWeight(pig);

        butcher.killPig(pig);

        vegetable vegetable = new vegetable();
        vegetable.name = "白菜";
        vegetable.Planted_in_the_ground();
        vegetable.grow_up();
        vegetable.ripe();
        vegetable.pick("张农夫");
        vegetable.Was_eat("小黑");

        person person = new person(20, "王五");
        person.eat();
        person.sleep();
    }
}