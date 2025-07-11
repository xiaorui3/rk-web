package 算法;

import java.util.*;

public class 字符统计 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char c=sc.next().charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int max=0;
        List<Character> list=new ArrayList<>();
        for(char key:map.keySet()){
            int x=map.get(key);
            if(x>max){
                list.clear();
                list.add(key);
                max=x;
            }else if(x==max){
                list.add(key);
            }
        }
    }
}
