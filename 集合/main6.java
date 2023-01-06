package 集合;

import java.util.Iterator;
import java.util.TreeSet;

public class main6 {
    public static void main(String[] args) {
        TreeSet <Integer> tree=new TreeSet<>();
        tree.add(4);
        tree.add(6);
        tree.add(1);
        for (Integer integer : tree) {
            if(integer==4){
                continue;
            }
            System.out.print(integer+" ");
        }
    }
}
