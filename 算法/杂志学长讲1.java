package 算法;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 杂志学长讲1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.next();
        String t =sc.next();
        Map<Character,Integer> maps = new HashMap<>();
        Map<Character,Integer> mapt = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            maps.put(a,maps.getOrDefault(a,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char a=s.charAt(i);
            mapt.put(a,mapt.getOrDefault(a,0)+1);
        }

    }
}
