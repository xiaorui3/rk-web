package 马士兵.JavaSE进阶.IO流;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class 利用字节流去读取 {
    public static void main(String[] args) throws IOException {
        //1.引入文件 创建流
        File f = new File("E:\\code\\马士兵\\JavaSE进阶\\IO流\\3.txt");
        FileInputStream fis = new FileInputStream(f);

        //3.读取流
        byte[] bytes = new byte[1024];
        int read = fis.read(bytes);

        while(read!=-1){
            String str = new String(bytes,0,read);
            System.out.println(str);
            read = fis.read(bytes);
        }

        //4.关闭流
        fis.close();
    }
}
