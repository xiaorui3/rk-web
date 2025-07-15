package 布卡.基础.ZY.ZY7_14;

public class Pig {
    private String name;
    private String breed;
    private int age;
    private double weight;

    public Pig(String name, String breed, int age, double weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public void gainWeight() {
        this.weight += 1;
    }

    public void eat(String food) {
        if (food.equals("大豆饲料")) {
            this.weight += 2;
            System.out.println(this.name + " 吃了大豆饲料，增重 2 斤");
        } else {
            System.out.println(this.name + " 吃了 " + food + "，无明显增重");
        }
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}