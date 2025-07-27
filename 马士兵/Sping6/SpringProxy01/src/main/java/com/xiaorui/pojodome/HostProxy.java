package com.xiaorui.pojodome;

public class HostProxy implements Host{
    private HostImpl HostImpl;

    public HostProxy(HostImpl HostImpl) {
        this.HostImpl = HostImpl;
    }

    @Override
    public Object rentHost(double money) {
        //看房子
        lookHost();
        //议价
        yiJia(money);
        //赚差价
        zhuanChaJia(money);
        //客户给钱
        fangDong(HostImpl.rentHost(money*0.8));
        //定期保洁
        baoJie();
        return null;
    }

    private void baoJie() {
    }

    private void fangDong(Object o) {
    }

    private void zhuanChaJia(double money) {
    }

    private void yiJia(double money) {
    }

    private void lookHost() {
    }
}
