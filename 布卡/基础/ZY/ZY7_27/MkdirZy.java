package 布卡.基础.ZY.ZY7_27;

import java.io.File;
import java.io.IOException;

public class MkdirZy {
    public static void main(String[] args) throws IOException {
        File f=new File("D:\\code\\code库\\code\\git_java\\布卡\\基础\\ZY\\ZY7_27\\test");
        System.out.println(f.getParent());
        String path=f.getParent();
        for (int i = 'a'; i <= 'z'; i++) {
            path+="\\"+(char)i;
            System.out.println(path);
            File kk=new File(path);
            boolean mkdir = kk.mkdir();
        }
        rmtest(path);

    }
    public static String rmtest(String path){
        File f=new File(path);
        File[] files = f.listFiles();
        for (File ff : files){
            if (ff.isDirectory()){
                boolean delete = f.delete();
                System.out.println(delete);
            }
        }
        //System.out.println(f.getParentFile());
        if (f.getParent().equals("D:\\code\\code库\\code\\git_java\\布卡\\基础\\ZY\\ZY7_27")){
            return "111";
        }
        return rmtest(String.valueOf(f.getParentFile()));

    }
}
