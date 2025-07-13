package 算法;

import java.util.Scanner;

public class 杂志学长讲2 {
    public static void main(String[] args) {
        int[] ms=new int[26],mt=new int[26];
        Scanner sc=new Scanner(System.in);
        String a=sc.next(),b=sc.next();
        for(int i=0;i<a.length();i++){
            char c=a.charAt(i);
             ms[c - 'a']++;
        }
        for(int i=0;i<b.length();i++){
            char c=a.charAt(i);
            mt[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(ms[i]<mt[i]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
