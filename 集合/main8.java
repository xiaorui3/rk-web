package 集合;

import java.util.Comparator;
import java.util.TreeSet;

public class main8 {
    public static void main(String[] args) {
        TreeSet<String> ts=new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i=o1.length()-o2.length();
                i=i==0?o1.compareTo(o2):i;
                return i;
            }
        });
        ts.add("a");
        ts.add("asd");
        ts.add("pqwd");
        ts.add("bsasd");
        ts.add("qwe");
        System.out.println(ts);
    }
}
