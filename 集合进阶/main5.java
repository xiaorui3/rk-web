package 集合进阶;

import java.util.*;

public class main5 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("张三", "男");
        map.put("李四", "男");
        map.put("王五", "女");
        map.put("赵六", "女");
        HashSet<String> r = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("--------------------------------");
        for (int i = 0; i < map.size() * n; ) {
            ArrayList<String> arr = new ArrayList<>();
            double random = Math.random();
            Random ra = new Random();
            int sum = 0;
            if (random >= 0.7) {
                for (int j = 0; j < 4; j++) {
                    for (String s : map.keySet()) {
                        String s1 = map.get(s);
                        if (s1.equals("男")) {
                            sum++;
                            arr.add(s);
                        }
                    }
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    for (String s : map.keySet()) {
                        String s1 = map.get(s);
                        if (s1.equals("女")) {
                            sum++;
                            arr.add(s);
                        }
                    }
                }
            }
            int i2 = ra.nextInt(sum);
            boolean add = r.add(arr.get(i2));
            if (add) {
                System.out.println(arr.get(i2));
                i++;
                if (i % map.size() == 0) {
                    System.out.println("--------------------------------");
                    r.clear();//i=0;
                }
            }
        }
    }
}
