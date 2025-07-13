package 算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 字符统计2 {
    static int[] a=new int[26];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        for(int i=0;i<str.length();i++) {
            char x = str.charAt(i);
            a[x - 'A']++;
        }
        List<Integer> list=new ArrayList<>();
        int max=0;
        for(int i=0;i<26;i++){
            if(a[i]>max){
                list.clear();
                max=a[i];
                list.add(i);
            }else if(a[i]==max){
                list.add(i);
            }
        }
    }
}
