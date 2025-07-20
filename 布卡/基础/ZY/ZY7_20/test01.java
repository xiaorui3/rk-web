package 布卡.基础.ZY.ZY7_20;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class test01 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "hello world";
        Field value = str.getClass().getDeclaredField("value");
        value.setAccessible(true);

        byte[] o = (byte[])value.get(str);
        o[1]='1';
        System.out.println(str);

        Class<?> clazz = str.getClass();
        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println(Arrays.toString(interfaces));


    }
}
