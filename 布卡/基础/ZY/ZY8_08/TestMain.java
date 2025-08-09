package 布卡.基础.ZY.ZY8_08;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) throws Exception {
        Class<?> car = Class.forName("布卡.基础.ZY.ZY8_08.Car");
        System.out.println(car);

        Constructor<?> constructor = car.getDeclaredConstructor(String.class, String.class,int.class);
        constructor.setAccessible(true);
        Car car1 = (Car)constructor.newInstance("轿车1", "品牌A",1);
        Car car2 = (Car)constructor.newInstance("轿车2", "品牌B",2);
        Car car3 = (Car)constructor.newInstance("轿车3", "品牌C",3);
        System.out.println(car1);
        Class<?> aClass = Class.forName("java.util.ArrayList");
        ArrayList o = (ArrayList)aClass.getDeclaredConstructor().newInstance();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(o,car1);
        add.invoke(o,car2);
        add.invoke(o,car3);
        //Method size = aClass.getMethod("size");
        //System.out.println(size.invoke(o));

        Method sizeMethod = aClass.getMethod("size");
        int size1 = (int) sizeMethod.invoke(o);
        System.out.println("ArrayList中的元素数量: " + size1);
        Field name = car.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(car.getMethod("toString").invoke(car1));
        name.set(car1,"改完的");
        System.out.println(car.getMethod("toString").invoke(car1));
        Method getMethod = aClass.getMethod("get", int.class);
        System.out.println("遍历ArrayList中的元素:");
        for (int i = 0; i < size1; i++) {
            Car car4 = (Car) getMethod.invoke(o, i);

            System.out.println(car4);
        }



    }
}
