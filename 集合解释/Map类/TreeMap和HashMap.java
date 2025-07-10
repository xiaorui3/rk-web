package java代码.集合解释.Map类;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class TreeMap和HashMap {
    /**
     * 方法名称	说明
     *     void clear()	删除该 Map 对象中的所有 key-value 对。
     *     boolean containsKey(Object key)	查询 Map 中是否包含指定的 key，如果包含则返回 true。
     *     boolean containsValue(Object value)	查询 Map 中是否包含一个或多个 value，如果包含则返回 true。
     *     V get(Object key)	返回 Map 集合中指定键对象所对应的值。V 表示值的数据类型
     *     V put(K key, V value)	向 Map 集合中添加键-值对，如果当前 Map 中已有一个与该 key 相等的 key-value 对，则新的 key-value 对会覆盖原来的 key-value 对。
     *     void putAll(Map m)	将指定 Map 中的 key-value 对复制到本 Map 中。
     *     V remove(Object key)	从 Map 集合中删除 key 对应的键-值对，返回 key 对应的 value，如果该 key 不存在，则返回 null
     *     boolean remove(Object key, Object value)	这是 Java 8 新增的方法，删除指定 key、value 所对应的 key-value 对。如果从该 Map 中成功地删除该 key-value 对，该方法返回 true，否则返回 false。
     *     Set entrySet()	返回 Map 集合中所有键-值对的 Set 集合，此 Set 集合中元素的数据类型为 Map.Entry
     *     Set keySet()	返回 Map 集合中所有键对象的 Set 集合
     *     boolean isEmpty()	查询该 Map 是否为空（即不包含任何 key-value 对），如果为空则返回 true。
     *     int size()	返回该 Map 里 key-value 对的个数
     *     Collection values()	返回该 Map 里所有 value 组成的 Collection*/


    public static void main(String[] args) {
        HashMap users = new HashMap();
        users.put("11", "张浩太"); // 将学生信息键值对存储到Map中
        users.put("22", "刘思诚");
        users.put("33", "王强文");
        users.put("44", "李国量");
        users.put("55", "王路路");
        System.out.println("******** 学生列表 ********");
        users.forEach(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println(o +""+ o2);
            }
        });
        Iterator it = users.keySet().iterator();
        while (it.hasNext()) {
            // 遍历 Map
            Object key = it.next();
            Object val = users.get(key);
            System.out.println("学号：" + key + "，姓名:" + val);
        }
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要删除的学号：");
        int num = input.nextInt();
        if (users.containsKey(String.valueOf(num))) { // 判断是否包含指定键
            users.remove(String.valueOf(num)); // 如果包含就删除
        } else {
            System.out.println("该学生不存在！");
        }
        System.out.println("******** 学生列表 ********");
        it = users.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            Object val = users.get(key);
            System.out.println("学号：" + key + "，姓名：" + val);
        }
    }
/*    TreeMap 类的使用方法与 HashMap 类相同，唯一不同的是 TreeMap 类可以对键对象进行排序，这里不再赘述。*/
}
