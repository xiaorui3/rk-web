package com.xiaorui.pojodome;

public class HostImpl implements Host{

    @Override
    public Object rentHost(double money) {
        System.out.println("房东的房子被出租了， 租金是 "+money+" /月");
        return new Object();
    }
}
