package com.xiaorui.pojodome;

/**
 *
 */

public class Customer {
    public static void main(String[] args) {
        HostProxy hp=new HostProxy(new HostImpl());
        Object o = hp.rentHost(5000);
        System.out.println(o);
    }
}
