package 布卡.基础.ZY.ZY7_27;

import java.io.File;

public class BianLiDir {
    private int k=0;
    public static void main(String[] args) {
        BianLiDir bianLiDir = new BianLiDir();
        bianLiDir.Dir("D:\\code\\code库\\code\\git_java");
        System.out.println("一共有："+bianLiDir.k+"个文件");
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
                k++;
            }
        }
        //System.out.println("一共有："+k+"个文件");
    }
}
