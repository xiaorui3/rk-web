package 布卡.基础.ZY.ZY7_24;

import java.util.ArrayList;
import java.util.List;

public class HomeWork01 {
    public static void main(String[] args) {
        List<Character> list1 = new ArrayList<>();
        list1.add('a');
        list1.add('b');
        list1.add('c');
        list1.add('d');
        list1.add('e');

        List<Character> list2 = new ArrayList<>();
        list2.add('b');
        list2.add('c');
        list2.add('d');
        list2.add('e');
        list2.add('f');
        ArrayListTestZeroOne(list1, list2);
    }
    public static void ArrayListTestZeroOne(List<Character> arr1, List<Character> arr2) {
        System.out.println("集合1: " + arr1);
        System.out.println("集合2: " + arr2);

        List<Character> jiao = new ArrayList<>();
        for (Character c : arr1) {
            if (arr2.contains(c) &&!jiao.contains(c)) {
                jiao.add(c);
            }
        }
        List<Character> bing = new ArrayList<>(arr1);
        for (Character c :arr2) {
            if (!bing.contains(c)) {
                bing.add(c);
            }
        }
        List<Character> cha = new ArrayList<>();
        for (Character c :arr1) {
            if (!arr2.contains(c)) {
                cha.add(c);
            }
        }
        for (Character c :arr2) {
            if (!arr1.contains(c)) {
                cha.add(c);
            }
        }
        System.out.println("交集: " + jiao);
        System.out.println("并集: " + bing);
        System.out.println("差集: " + cha);
    }
}
