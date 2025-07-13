package lanqiaomoni;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a=scan.next();
        List<Integer> list=new ArrayList<>();
        List<String> list1=new ArrayList<>();
        for(int arr=a.length(),i=0;arr!=0;arr--){
            list1.add(String.valueOf(a.charAt(i)));
            i++;
        }
        Iterator<String> it= list1.iterator();
            for(int i=0;i<a.length();i++){
                int shu=0;
                for(int j=0;j< a.length();j++){
                    //if(i!=j){
                        if(a.charAt(i)==a.charAt(j)){
                            shu++;
                        }
                    //}
                }list.add(shu);
            }
            int max=-1;
            for(int i=0;i<a.length();i++){
                max=Math.max(max,list.get(i));
            }
            int p=0;
            for(int i=0;i<a.length();i++){
                if(list.get(i)==max){
                    p=i;
                    break;
                }
            }
        System.out.println(a.charAt(p));
        System.out.println(max+1);
        scan.close();
    }
}