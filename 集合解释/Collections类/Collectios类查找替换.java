package java代码.集合解释.Collections类;

import java.util.ArrayList;
import java.util.Collections;

public class Collectios类查找替换 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(3);
        list.add(-2);
        list.add(9);
        list.add(5);
        list.add(-1);
        list.add(6);
        //[3, -2, 9, 5, -1, 6]
        System.out.println(list);

        //输出最大元素9
        System.out.println(Collections.max(list));

        //输出最小元素：-2
        System.out.println(Collections.min(list));

        //将list中的-2用1来代替
        System.out.println(Collections.replaceAll(list, -2, 1));
        //[3, 1, 9, 5, -1, 6]
        System.out.println(list);

        list.add(9);
        //判断9在集合中出现的次数，返回2
        System.out.println(Collections.frequency(list, 9));

        //对集合进行排序
        Collections.sort(list);
        //[-1, 1, 3, 5, 6, 9, 9]
        System.out.println(list);
        //只有排序后的List集合才可用二分法查询，输出2
        System.out.println(Collections.binarySearch(list, 3));

/**
 *      3.1、方法
 * 　　1） static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key)
 *
 * 　　　　使用二分搜索法搜索指定列表，以获得指定对象在List集合中的索引。
 *
 * 　　　　注意：此前必须保证List集合中的元素已经处于有序状态。
 *
 * 　　2）static Object max(Collection coll)
 *
 * 　　　　 根据元素的自然顺序，返回给定collection 的最大元素。
 *
 * 　　3）static Object max(Collection coll,Comparator comp):
 *
 * 　　　　根据指定比较器产生的顺序，返回给定 collection 的最大元素。
 *
 * 　　4）static Object min(Collection coll):
 *
 * 　　　　根据元素的自然顺序，返回给定collection 的最小元素。
 *
 * 　　5）static Object min(Collection coll,Comparator comp):
 *
 * 　　　　根据指定比较器产生的顺序，返回给定 collection 的最小元素。
 *
 * 　　6） static <T> void fill(List<? super T> list, T obj) :
 *
 * 　　　　使用指定元素替换指定列表中的所有元素。
 * 　　7）static int frequency(Collection<?> c, Object o)
 *
 * 　　　　返回指定 collection 中等于指定对象的出现次数。
 * 　　8）static int indexOfSubList(List<?> source, List<?> target) :
 *
 * 　　　　返回指定源列表中第一次出现指定目标列表的起始位置；如果没有出现这样的列表，则返回 -1。
 * 　　9）static int lastIndexOfSubList(List<?> source, List<?> target)
 *
 * 　　　　返回指定源列表中最后一次出现指定目标列表的起始位置；如果没有出现这样的列表，则返回 -1。
 * 　　10）static <T> boolean replaceAll(List<T> list, T oldVal, T newVal)
 *
 * 　　　　使用一个新值替换List对象的所有旧值oldVal
 */
    }
}
