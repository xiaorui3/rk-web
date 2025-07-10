package java代码.集合解释.Collections类;

import java.util.*;

public class Collectios类同步控制 {
    public static void main(String[] args)
    {
        //下面程序创建了四个同步的集合对象
        Collection c = Collections.synchronizedCollection(new ArrayList());
        List list = Collections.synchronizedList(new ArrayList());
        Set s = Collections.synchronizedSet(new HashSet());
        Map m = Collections.synchronizedMap(new HashMap());
        /**
         *    4.1、方法
         * 　　1）static <T> Collection<T> synchronizedCollection(Collection<T> c)
         *
         * 　　　　返回指定 collection 支持的同步（线程安全的）collection。
         * 　　2）static <T> List<T> synchronizedList(List<T> list)
         *
         * 　　　　返回指定列表支持的同步（线程安全的）列表。
         * 　　3）static <K,V> Map<K,V> synchronizedMap(Map<K,V> m)
         *
         * 　　　　返回由指定映射支持的同步（线程安全的）映射。
         * 　　4）static <T> Set<T> synchronizedSet(Set<T> s)
         *
         * 　　　　 返回指定 set 支持的同步（线程安全的）set。
         */
    }
}
