package w5;


public abstract class shuzi {
    private long shuzi_1;
    public long getShuzi_1() {
        return shuzi_1;
    }

    public void setShuzi_1(long shuzi_1) {
        this.shuzi_1 = shuzi_1;
    }

    public shuzi(long shuzi_1) {
        this.shuzi_1 = shuzi_1;
    }
    public shuzi(){}
    public abstract boolean zhuanhuan(long getShuzi);
}
