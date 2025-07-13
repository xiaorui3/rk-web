package 异常;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class main4 {
    public static void main(String[] args) {
        //  先放代码
        ArrayList<String> list = new ArrayList<>();
        //添加
        Collections.addAll(list,"abcd","sdf","dsefgh","wethz","abc","juax");
        //调用排序函数sort从小到大排序
/*        Collections.sort(list, (o1, o2) -> {
            //是否字符数量相同
            int i = o1.length() - o2.length();
            //如果相同那么就比较两个的ascll
            i = i == 0 ? o1.compareTo(o2) : i;
            return i;
        });*/
        //打印list
        System.out.println(list);
            int m=Collections.binarySearch(list, "sdf");
            if(m>0){
                System.out.println(m);
            }
        //System.out.println(m);
    }
}
