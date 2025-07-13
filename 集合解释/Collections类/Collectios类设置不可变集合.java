package java代码.集合解释.Collections类;

import java.util.*;

public class Collectios类设置不可变集合 {
    public static void main(String[] args)
    {
        //创建一个空的、不可改变的List对象
        List<String> unmodifiableList = Collections.emptyList();
        //unmodifiableList.add("java");  //添加出现异常：java.lang.UnsupportedOperationException
        System.out.println(unmodifiableList);// []
        //创建一个只有一个元素，且不可改变的Set对象
        Set unmodifiableSet = Collections.singleton("Struts2权威指南");//[Struts2权威指南]
        System.out.println(unmodifiableSet);
        //创建一个普通Map对象
        Map scores = new HashMap();
        scores.put("语文" , 80);
        scores.put("Java" , 82);
        //返回普通Map对象对应的不可变版本
        Map unmodifiableMap = Collections.unmodifiableMap(scores);
        //下面任意一行代码都将引发UnsupportedOperationException异常
        unmodifiableList.add("测试元素");
        unmodifiableSet.add("测试元素");
        unmodifiableMap.put("语文",90);
/**
 *        5.1、方法
 * 　　1）emptyXxx()
 *
 * 　　　　 返回一个空的、不可变的集合对象，此处的集合既可以是List，也可以是Set，还可以是Map。
 *
 * 　　2）singletonXxx():
 *
 * 　　　　返回一个只包含指定对象（只有一个或一个元素）的不可变的集合对象，此处的集合可以是：List，Set，Map。
 *
 * 　　3）unmodifiableXxx():
 *
 * 　　　　返回指定集合对象的不可变视图，此处的集合可以是：List，Set，Map。
 *
 * 　　上面三类方法的参数是原有的集合对象，返回值是该集合的”只读“版本。
 */
    }
}
