package 马士兵.JavaSE进阶.反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String str="马士兵.JavaSE进阶.反射.WX";
        Class<?> aClass = Class.forName(str);
        Object o = aClass.newInstance();
        Method payOnline = aClass.getMethod("payOnline");
        payOnline.invoke(o);

    }

}
