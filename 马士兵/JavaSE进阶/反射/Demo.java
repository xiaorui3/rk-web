package 马士兵.JavaSE进阶.反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //MTWM m =new WX();
        //m.payOnline();
        String str="马士兵.JavaSE进阶.反射.ZFB";
        Class aClass = Class.forName(str);
        Object o = aClass.newInstance();//创建对象
        Method payOnline = aClass.getMethod("payOnline");//获取方法
        payOnline.invoke(o);//调用方法

    }
}
