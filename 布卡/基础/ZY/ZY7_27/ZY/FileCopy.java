package 布卡.基础.ZY.ZY7_27.ZY;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        File f1=new File("D:\\code\\code库\\code\\git_java\\布卡\\基础\\ZY\\ZY7_27\\copy12\\1.txt");

        FileInputStream fis =new FileInputStream(f1);
        byte[] b=new byte[1024];
        int read=0;
        File f2=new File("D:\\code\\code库\\code\\git_java\\布卡\\基础\\ZY\\ZY7_27\\copy12\\2.txt");
        FileOutputStream fos =new FileOutputStream(f2);
        while((read=fis.read(b))!=-1){
            fos.write(b,0,read);
        }
        fos.flush();

        fos.close();
        fis.close();

    }
}
