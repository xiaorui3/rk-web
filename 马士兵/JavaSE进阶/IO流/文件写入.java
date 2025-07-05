package 马士兵.JavaSE进阶.IO流;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 文件写入 {
    public static void main(String[] args) throws IOException {
        File f = new File("E:\\code\\马士兵\\JavaSE进阶\\IO流\\2.txt");
        FileWriter fw=new FileWriter(f);
        String str = "你好世界";
        fw.write(str);
        FileReader fr = new FileReader(new File("E:\\code\\马士兵\\JavaSE进阶\\IO流\\2.txt"));
        fw.close();
        char[] ch = new char[1024];
        int read = fr.read(ch);
        while(read!=-1){
            String str2 =new String(ch,0, read);
            System.out.println(str2);
            read = fr.read(ch);
        }
        fr.close();
    }
}
