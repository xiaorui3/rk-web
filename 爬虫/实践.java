package java代码.爬虫;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class 实践 {
    public static void main(String[] args) throws IOException {
        //创建URL对象
        URL url=new URL("http://www.hhhxy.cn/");
        //连接上这个网站
        //细节:保证网络畅通
        URLConnection coon=url.openConnection();
        //创建一个对象去读取
        BufferedReader br=new BufferedReader(new InputStreamReader(coon.getInputStream()));
        String line;
        int aus=0;
        while ((line=br.readLine())!=null) {
            Pattern h = null;
            try {
                h = Pattern.compile(line);
            } catch (PatternSyntaxException e) {

            }
            if(h != null){
                Matcher m = h.matcher("黑河学院");
                while (m.find()) {
                    aus++;
                }
            }
            System.out.println(line);
        }
        System.out.println("该网页黑河学院四个字共出现"+aus+"次");
    }
}
