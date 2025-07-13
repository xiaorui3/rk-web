package File;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class FileDemo01 {
    public static void main(String[] args) throws IOException {
        File f1=new File("C:\\Users\\35054\\Desktop\\a");
        //boolean b = f1.delete();
        //boolean b1 = f1.mkdirs();
        System.out.println(Arrays.toString(File.listRoots()));
        File[] files = f1.listFiles();
        assert files != null;
        f(files);
        System.out.println("============================");



        String[] list1 = f1.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File src = new File(dir , name);
                return src.isFile()&&name.endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(list1));
        File[] files1 = f1.listFiles();
        assert files1 != null;
        for (File file : files1) {
            if(file.isFile()&&file.getName().endsWith(".txt")){  
                System.out.println(file);
            }
        }
        System.out.println("============================");
        for (File file : Objects.requireNonNull(f1.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        })))
            System.out.println(file);

    }
    public static void f(File[] files){
        for (File file : files) {
            if(file.isDirectory()){
                System.out.println(file+"\t\t文件夹");
                File[] files1 = file.listFiles();
                assert files1 != null;
                f(files1);
            }
            else{
                System.out.println(file);
            }
        }
    }

}
