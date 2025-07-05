package 马士兵.JavaSE进阶.IO流;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class 文件读取 {
    public static void main(String[] args) throws IOException {
        FileReader fr =new FileReader(new File("E:\\code\\马士兵\\JavaSE进阶\\IO流\\1.txt"));

        char[] c = new char[1024];
        int read = fr.read(c);
        System.out.println(read);
        while(read!=-1){
            String str =new String(c,0,read);
            System.out.println(str);
            read = fr.read(c);
        }

        fr.close();
    }
}
