package java代码.集合解释.Collections类;

import java.util.ArrayList;
import java.util.Collections;

public class Collectios类排序 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(3);
        list.add(-2);
        list.add(9);
        list.add(5);
        list.add(-1);
        list.add(6);
        //输出：[3, -2, 9, 5, -1, 6]
        System.out.println(list);
        //集合元素的次序反转
        Collections.reverse(list);
        //输出：[6, -1, 5, 9, -2, 3]
        System.out.println(list);

        //排序：按照升序排序
        Collections.sort(list);
        //[-2, -1, 3, 5, 6, 9]
        System.out.println(list);

        //根据下标进行交换
        Collections.swap(list, 2, 5);
        //输出：[-2, -1, 9, 5, 6, 3]
        System.out.println(list);

        /*//随机排序
        Collections.shuffle(list);
        //每次输出的次序不固定
        System.out.println(list);*/

        //后两个整体移动到前边
        Collections.rotate(list, 2);
        //输出：[6, 9, -2, -1, 3, 5]
        System.out.println(list);

        /**
         * 2.1、方法
         * 　　1）static void reverse(List<?> list):
         *
         * 　　　　反转列表中元素的顺序。
         *
         * 　　2）static void shuffle(List<?> list) :
         *
         * 　　　　对List集合元素进行随机排序。
         *
         * 　　3） static void sort(List<T> list)
         *
         * 　　　　根据元素的自然顺序 对指定列表按升序进行排序
         * 　　4）static <T> void sort(List<T> list, Comparator<? super T> c) :
         *
         * 　　　　根据指定比较器产生的顺序对指定列表进行排序。
         * 　　5）static void swap(List<?> list, int i, int j)
         *
         * 　　　　在指定List的指定位置i,j处交换元素。
         *
         * 　　6）static void rotate(List<?> list, int distance)
         *
         * 　　　　当distance为正数时，将List集合的后distance个元素“整体”移到前面；当distance为负数时，将list集合的前distance个元素“整体”移到后边。该方法不会改变集合的长度。
         */
    }
}
