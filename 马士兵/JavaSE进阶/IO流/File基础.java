package 马士兵.JavaSE进阶.IO流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class File基础 {
    public static void main(String[] args) throws IOException {
        File f=new File("E:\\code\\马士兵\\JavaSE进阶\\IO流\\1.txt");
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
        System.out.println(f.canRead());
        System.out.println(f.canWrite());
        System.out.println(f.getName());
        System.out.println(f.getParent());
        System.out.println(f.getParentFile());
        System.out.println(f.getPath());
        System.out.println(f.length());
        System.out.println(f.exists());
        if(f.exists()){
            f.delete();
        }else{
            f.createNewFile();
        }
    }
}
