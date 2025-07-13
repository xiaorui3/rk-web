package 算法;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class 两数之和哈希表 {
    static int N=110;
    static int[] a=new int[N];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            a[i]= sc.nextInt();
            map.put(a[i],i);
        }
        int t=sc.nextInt();
        for(int i=0;i<n;i++){
            int A=a[i];
            if(map.containsKey(t-A)){
                System.out.println(i+" "+map.get(t-A));
            }
        }
        Set<Integer> set = map.keySet();
        System.out.println(set);
        System.out.println(map);
        System.out.println(map.values());
    }
}
