package com.xiaorui.pojodemo02;

public class ZhongJie implements Host{
    private FangDong FangDong;

    public void setHost(FangDong FangDong) {
        this.FangDong = FangDong;
    }

    @Override
    public Object zuFang(double money) {
        System.out.println("中介开始");
        Object o = FangDong.zuFang(money);
        System.out.println("中介结束");
        return o;
    }
}
