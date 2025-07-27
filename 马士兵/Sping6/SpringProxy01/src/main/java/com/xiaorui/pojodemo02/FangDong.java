package com.xiaorui.pojodemo02;

public class FangDong implements Host{
    @Override
    public Object zuFang(double money) {
        System.out.println("我是房东，我现在要开始收钱了，我会给你返回一个房子！ 我收到了 "+money+" 元");
        return new Object();
    }
}
