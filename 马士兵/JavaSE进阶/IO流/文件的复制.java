package 马士兵.JavaSE进阶.IO流;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 文件的复制 {
    public static void main(String[] args){
        File f1=new File("E:\\code\\马士兵\\JavaSE进阶\\IO流\\2.txt");
        File f2=new File("E:\\code\\马士兵\\JavaSE进阶\\IO流\\3.txt");
        try{
            if (!f2.exists()) {
                f2.createNewFile();
            }
            FileReader fr = new FileReader(f1);
            FileWriter fw =new FileWriter(f2);
            char[] c = new char[1024];
            int read = fr.read(c);
            while(read!=-1){
                String str =new String(c,0,read);
                fw.write(str);
                System.out.println(str);
                read = fr.read(c);
            }
            fr.close();
            fw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
