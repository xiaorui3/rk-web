package relationship;

public class TestMain {

    public static void main(String[] args) {
        //1.创建对象
//        Wheel wheel = new Wheel();
//        wheel.brand = "普利司通";
//        wheel.size = 18;

//        Car car = new Car();
//        car.brand = "Benz";
//        car.size = "AMG G63";
//        car.color = "yellow";
//        car.wheel = wheel;

        ////////////////////////////////////////////////
//        Wheel wheel1 = new Wheel("米其林1",18);
//        Wheel wheel2 = new Wheel("米其林2",18);
//        Wheel wheel3 = new Wheel("米其林3",18);
//        Wheel wheel4 = new Wheel("米其林4",18);
//
//        Wheel[] wheels = {wheel1,wheel2,wheel3,wheel4};
//
//        Car car = new Car("BMW","Z4","Pink",wheels);
//        car.run();

        /////////////////////////////////////////
        Computer computer = new Computer("HUAWEI","black");
        People people = new People("zzt");
        people.eat();
        people.useComputer(computer);

    }
}
