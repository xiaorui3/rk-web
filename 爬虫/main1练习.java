package 爬虫;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main1练习 {
    public static void main(String[] args) throws IOException {
        URL sfz=new URL("https://mooc1.chaoxing.com/mooc2/work/dowork?courseId=224183351&classId=65425497&cpi=267248075&workId=24543725&answerId=0&standardEnc=dc5302b8910441b055eb44a46bb9787c&enc=d126c22bfbecee8e209e66eaf13d73e1");
        URLConnection sfz_1= sfz.openConnection();
        BufferedReader sfz_2=new BufferedReader(new InputStreamReader(sfz_1.getInputStream()));
        String pp="[\\W]{0,3}\\s[1-9][0-9]{16}(X|x|[0-9])";
        Pattern pa=Pattern.compile(pp);
        String li;
        while ((li= sfz_2.readLine())!=null){
            Matcher m = pa.matcher(li);
            System.out.println(li);
            while (m.find()){
                System.out.println(m.group());
            }
        }

    }
}
