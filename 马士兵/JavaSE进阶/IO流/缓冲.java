package 马士兵.JavaSE进阶.IO流;

import java.io.*;

public class 缓冲 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\code\\马士兵\\JavaSE进阶\\IO流\\AA1I0kMM.jpg");
        FileOutputStream fos = new FileOutputStream("E:\\code\\马士兵\\JavaSE进阶\\IO流\\AA1I0kMM1.jpg");

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] bytes = new byte[1024*8];
        int read = bis.read(bytes);
        while(read!=-1){
            String str = new String(bytes,0,read);
            //System.out.println(str);
            bos.write(bytes,0,read);
            read = bis.read(bytes);
        }

        bos.close();
        bis.close();

        fos.close();
        fis.close();
    }
}
