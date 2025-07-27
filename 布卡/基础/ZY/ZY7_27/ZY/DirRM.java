package 布卡.基础.ZY.ZY7_27.ZY;

import java.io.File;

public class DirRM {
    public static void main(String[] args) {
        new DirRM().Dir("D:\\code\\code库\\code\\git_java\\布卡\\基础\\ZY\\ZY7_27\\copy12");
    }
    public void Dir(String dir){

        System.out.println("111");
        File f=new File(dir);
        if (f.exists()){
            if (f.isDirectory()){
                File[] files = f.listFiles();
                if (files != null) {
                    for (File ff:files){
                        Dir(ff.getPath().toString());
                    }
                }
            }else{
                System.out.println(f.getAbsolutePath());
                f.delete();
            }
        }
        //System.out.println("一共有："+k+"个文件");
    }
}
