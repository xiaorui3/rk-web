package test;

import java.lang.reflect.Field;

public class TestString {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "abc";

        //隔了好多行
        //1.获取str对象对应的那个类   ---属性---属于哪个对象的
        //  三种获取类的方法
        //  Class clazz = Class.forName("包.类");
        //  Class clazz = 类名.class;
        //  Class clazz = 对象.getClass();
        Class clazz = str.getClass();//     String的运行时类
        //2.通过类获取里面描述的那个value属性
//        Field field = clazz.getField("value");
        Field field = clazz.getDeclaredField("value");
        //设置一下属性可以被操作
        field.setAccessible(true);
        //直接操作属性
        char[] v = (char[])field.get(str);             //char[] v = str.value;
        v[0] = 'z';
        v[1] = 'z';
        v[2] = 't';
        //3.找到这个value属性对应的那个对象  str
        System.out.println(str);//abc
    }
}
