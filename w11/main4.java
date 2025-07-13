package w11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main4 {
    public static void main(String[] args) {
        String str="6666";
        Pattern p=Pattern.compile("\\d{0,4}");
        Matcher m = p.matcher(str);
        for(boolean b = m.find();b!=false;){
            String group = m.group();
            System.out.println(group);
        }
    }
}
