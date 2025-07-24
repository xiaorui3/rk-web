package 布卡.基础.ZY.ZY7_24;

import java.util.ArrayList;
import java.util.List;

public class HomeWork02 {
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
        ArrayListTestZeroOne(list1,list2);
    }
    public static void ArrayListTestZeroOne(List<Character> arr1,List<Character> arr2){
        System.out.println("集合1: "+arr1.toString());
        System.out.println("集合2: "+arr2.toString());

        List<Character> jiao =new ArrayList<>();
        List<Character> bing =new ArrayList<>(arr1);
        List<Character> cha =new ArrayList<>();
        for (int i = 0; i < arr1.size(); i++) {
            int m=0;
            List<Integer> ll=new ArrayList<>();
            for (int j = 0; j < arr2.size(); j++) {
                if (arr1.get(i).equals(arr2.get(j))){
                    jiao.add(arr1.get(i));
                    m=1;
                }
                if (arr1.contains(arr2.get(j))){
                    bing.add(arr2.get(j));
                }
                if (m==0){
                    ll.add(j);
                }

            }
            if (m==0){
                cha.add(arr1.get(i));
                if (arr2.size()!=ll.size()){
                    for (int j = 0; j < arr2.size(); j++) {
                        if (j!=ll.get(j)){
                            cha.add(arr2.get(j));
                        }
                    }
                }

            }
        }
        System.out.println(jiao.toString());
        System.out.println(bing.toString());
        System.out.println(cha.toString());

    }
}
