package com.xiaorui.pojodemo02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ZuKE implements InvocationHandler {
    private FangDong FangDong;

    public void setFangDong(com.xiaorui.pojodemo02.FangDong fangDong) {
        FangDong = fangDong;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理中介开始");
        Object invoke = method.invoke(FangDong, args);
        System.out.println("代理中介结束");
        return invoke;
    }
}
