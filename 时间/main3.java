package 时间;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class main3 {
    public static void main(String[] args) throws ParseException {
        Scanner lu=new Scanner(System.in);
        //lu.useDelimiter("\n");
        ArrayList<main4> str=new ArrayList<>();
        int n= lu.nextInt();
        for(int i=0;i<n;i++){
            main4 str1=new main4();
            str1.setName(lu.next());
            str1.setSheng(lu.nextLine());
            str.add(str1);
        }
        long[] sheng=new long[n];
        String[] ren=new String[n];
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy MM dd");
        for(int i=0;i<str.size();i++){
            Date parse = sdf.parse(str.get(i).getSheng());
            sheng[i]= parse.getTime();
            ren[i]=str.get(i).getName();
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n-i;j++){
                if(sheng[j-1]>sheng[j]){
                    long a=sheng[j-1];
                    sheng[j-1]=sheng[j];
                    sheng[j]=a;
                    String b=ren[j-1];
                    ren[j-1]=ren[j];
                    ren[j]=b;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(ren[i]);
        }
    }
}
