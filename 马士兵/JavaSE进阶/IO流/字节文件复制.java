package 马士兵.JavaSE进阶.IO流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class 字节文件复制 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\code\\马士兵\\JavaSE进阶\\IO流\\AA1I0kMM.jpg");
        FileOutputStream fos = new FileOutputStream("E:\\code\\马士兵\\JavaSE进阶\\IO流\\AA1I0kMM1.jpg");

        byte[] bytes = new byte[1024];
        int read = fis.read(bytes);
        while(read!=-1){
            String str = new String(bytes,0,read);
            //System.out.println(str);
            fos.write(bytes,0,read);
            read = fis.read(bytes);
        }

        fos.close();
        fis.close();
    }
}
