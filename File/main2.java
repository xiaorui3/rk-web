package File;

import java.io.File;
import java.io.IOException;

public class main2 {
    public static void main(String[] args) throws Exception,IOException {
        String str="C:\\Users\\35054\\Desktop";
        String str1="a.txt";
        File f1=new File(str,str1);
        System.out.println(f1.exists());
        boolean newFile = f1.createNewFile();
        if(newFile){
            System.out.println("文件创建成功");
        }
        else{
            System.out.println("文件"+str1.split("\\.")[0]+"已经存在");
            f1.delete();
            //throw new Exception("未知错误!");
        }
        File f2=new File("C:\\Users\\35054\\Desktop\\a\\b\\d\\q");
        boolean b = f2.mkdirs();
        f1.delete();
        System.out.println(b);
    }
}
