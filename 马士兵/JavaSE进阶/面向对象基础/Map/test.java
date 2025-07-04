package 马士兵.JavaSE进阶.面向对象基础.Map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class test {
    public static void main(String[] args) {
        Map<String,Integer> map= new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
}
