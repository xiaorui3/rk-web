package 布卡.基础.ZY.ZY7_27.ZY;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DirCopy {
    public static void main(String[] args) throws IOException {

        File f1=new File("D:\\code\\code库\\code\\git_java\\布卡\\基础\\ZY\\ZY7_27\\copy12");
        DirCV(f1.getAbsolutePath().toString());

    }
    public static void DirCV(String dir1) throws IOException {

        File f=new File(dir1);
        if (f.exists()){
            if (f.isDirectory()){
                File file = new File(f.getPath().toString().replace("copy12", "copy13"));
                file.mkdir();
                System.out.println(file.getAbsolutePath());
                File[] files = f.listFiles();
                if (files != null) {
                    for (File ff:files){

                        DirCV(ff.getPath().toString());
                    }
                }
            }else{
                //System.out.println(f.getAbsolutePath());
                File file = new File(f.getPath().toString().replace("copy12", "copy13"));
                //System.out.println(file.getAbsolutePath());
                file.createNewFile();
                File f1=new File(f.getAbsolutePath());

                FileInputStream fis =new FileInputStream(f1);
                byte[] b=new byte[1024];
                int read=0;
                FileOutputStream fos =new FileOutputStream(file);
                while((read=fis.read(b))!=-1){
                    fos.write(b,0,read);
                }
                fos.flush();

                fos.close();
                fis.close();
                //f.delete();
            }
        }
        //System.out.println("一共有："+k+"个文件");
    }
}
