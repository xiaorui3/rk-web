package w6;

import java.util.ArrayList;
import java.util.Scanner;


public class shuru {
    static Scanner lu=new Scanner(System.in);
    private long[] shuzi;
    private ArrayList<Long> list=new ArrayList<>();
    public long[] getShuzi() {
        return shuzi;
    }
    public boolean setShuzi_1(){
        long k=lu.nextLong();
        if(k!=0){
            list.add(k);
            return setShuzi_1();
        }
        else{
            return true;
        }
    }
    public void printf(){
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
    }
    public void setShuzi(long[] shuzi) {
        this.shuzi = shuzi;
    }

    public ArrayList<Long> getList() {
        return list;
    }

    public void setList(ArrayList<Long> list) {
        this.list = list;
    }

    public shuru(long[] shuzi, ArrayList<Long> list) {
        this.shuzi = shuzi;
        this.list = list;
    }
    public shuru(){}
    
}
