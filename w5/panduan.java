package w5;

import java.util.ArrayList;

public class panduan extends shuzi{
    static ArrayList<Long> list =new ArrayList<>();
	@Override
	public boolean zhuanhuan(long getShuzi) {
        list.add(getShuzi);
        if(getShuzi!=1){
		if(getShuzi%2==1){
            setShuzi_1(getShuzi*3+1);
        }
        else{
            setShuzi_1(getShuzi/2);
        }
        return zhuanhuan(this.getShuzi_1());
        }
        else{
            for(int i=list.size()-1;i>=0;i--){
                System.out.print(list.get(i)+" ");
            }
        }
		return true;
	}
    public panduan(long shuzi_1) {
        super(shuzi_1);
    }
    public panduan() {
    }
    
}
