package 爬虫;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main1 {
    public static void main(String[] args) throws IOException {
        URL bilibili=new URL("http://www.onecf.cn/richang/201908195731.html");
        URLConnection bili=bilibili.openConnection();/*331511199911154000*/
        BufferedReader chunchu=new BufferedReader(new InputStreamReader(bili.getInputStream()));
        String pp="[\\W]{0,3}\\s[1-9][0-9]{16}(X|x|[0-9])";
        Pattern pa= Pattern.compile(pp);
        String li;
        while((li=chunchu.readLine())!=null) {
            Matcher m = pa.matcher(li);
            while(m.find()){
                System.out.println(m.group());
            }
        }
    }
}
