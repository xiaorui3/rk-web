package File;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main1 {
    public static void main(String[] args) throws IOException {
/*        String str="C:\\Users\\35054\\Desktop";
        String a="a95d30d3d539b600491e1c55e850352ac45cb797.jpg";
        File f1=new File(str,a);
        f1.createNewFile();
        long length = f1.length();
        System.out.println(length);
        //f1.list ()
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println(f1.exists());
        System.out.println(f1);*/
        String str1="C:\\Users\\35054\\Desktop";
        String a1="a.txt";
        File f11=new File(str1,a1);
        boolean newFile = f11.createNewFile();
        long length1 = f11.length();
        System.out.println(length1);
        System.out.println(f11.isDirectory());
        System.out.println(f11.isFile());
        System.out.println(f11.exists());
        System.out.println(f11.getAbsolutePath());
        System.out.println(f11);
        System.out.println(f11.getPath());
        System.out.println(f11.getName());
        long date=f11.lastModified();
        Date da=new Date(date);
        SimpleDateFormat s=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = s.format(da);
        System.out.println(format);
        System.out.println(f11.lastModified());
        System.out.println("===================");
        File f2=new File("java\\Desktop.eml");
        System.out.println(f2.getAbsolutePath());
        System.out.println(f2.exists());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println(f2.getPath());
        System.out.println(f2.getName());
        System.out.println(f2.lastModified());
    }
}
