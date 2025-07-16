package 马士兵.JDBC.JDBCTest01.src;

import java.util.ArrayList;

public class Print<E> {
    public void Println(ArrayList<E> e){
        for (int i = 0; i < e.size(); i++) {
            String string = e.get(i).toString();
            System.out.println(string);
        }
    }

}
