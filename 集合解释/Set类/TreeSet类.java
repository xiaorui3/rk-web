package java代码.集合解释.Set类;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet类 {
    /**
     * TreeSet 只能对实现了 Comparable 接口的类对象进行排序，
     *     因为 Comparable 接口中有一个 compareTo(Object o) 方法用于比较两个对象的大小。
     *     例如 a.compareTo(b)，如果 a 和 b 相等，则该方法返回 0；如果 a 大于 b，
     *     则该方法返回大于 0 的值；如果 a 小于 b，则该方法返回小于 0 的值。
     * @param args
     */
    public static void main(String[] args) {
    TreeSet<Integer> tree=new TreeSet<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    });
/**
 * 包装类（BigDecimal、Biglnteger、 Byte、Double、
 *     Float、Integer、Long 及 Short)	按数字大小比较
 *     Character	按字符的 Unicode 值的数字大小比较
 *     String	按字符串中字符的 Unicode 值的数字大小比较
 *     TreeSet 类除了实现 Collection 接口的所有方法之外，还提供了如表 2 所示的方法。
 *
 *     表 2 TreeSet类的常用方法
 *     方法名称	说明
 *     E first()	返回此集合中的第一个元素。其中，E 表示集合中元素的数据类型
 *     E last()	返回此集合中的最后一个元素
 *     E poolFirst()	获取并移除此集合中的第一个元素
 *     E poolLast()	获取并移除此集合中的最后一个元素
 *     SortedSet<E> subSet(E fromElement,E toElement)	返回一个新的集合，新集合包含原集合中 fromElement 对象与 toElement
 *     对象之间的所有对象。包含 fromElement 对象，不包含 toElement 对象
 *     SortedSet<E> headSet<E toElement〉	返回一个新的集合，新集合包含原集合中 toElement 对象之前的所有对象。
 *     不包含 toElement 对象
 *     SortedSet<E> tailSet(E fromElement)	返回一个新的集合，新集合包含原集合中 fromElement 对象之后的所有对
 *     象。包含 fromElement 对象
 */
    }
}
