package 爬虫;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main2 {
    public static void main(String[] args) {
        String a1="来黑马程序员学习Java,电话:18512516758,18512508907，或者联系邮箱：boniu@itcast.cn，座机电话：01036517895，010-98951256，邮箱：bozai@itcast.cn，热线" +
                "电话：400-618-9090,400-618-4000,4006184000,4006189090";
        ArrayList<Pattern> p=new ArrayList<>();
        ArrayList<String> str=new ArrayList<>();
        Pattern p1=Pattern.compile("黑马程序员");
        Pattern p2=Pattern.compile("[1-9][3-9][0-9]{9}");
        Pattern p3=Pattern.compile("[a-zA-Z0-9]{3,}@[a-zA-Z0-9]{3,}\\.cn");
        Pattern p4=Pattern.compile("010-?[0-9]{8}");
        Pattern p5=Pattern.compile("400-?[0-9]{3}-?[0-9]{4}");
        //Pattern p = Pattern.compile();
        str.add("黑马程序员:");str.add("电话:");str.add("联系邮箱:");str.add("座机电话:");str.add("邮箱:");str.add("热线电话:");
        p.add(p1);p.add(p2);p.add(p3);p.add(p4);p.add(p5);
        for(int i=0;i<5;i++){
            Matcher m = p.get(i).matcher(a1);
            System.out.print(str.get(i));
            int k=1;
            while(m.find()) {
                if(k>1){
                    System.out.println("\t"+m.group());
                }
                else{
                    System.out.println(m.group());
                    k++;
                }
            }
        }



    }
}
