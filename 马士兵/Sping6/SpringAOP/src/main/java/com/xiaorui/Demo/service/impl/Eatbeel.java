package com.xiaorui.Demo.service.impl;

import com.xiaorui.Demo.service.Eat;
import org.springframework.stereotype.Service;

@Service
public class Eatbeel implements Eat {
    @Override
    public void eat() {
        System.out.println("吃beel中");
    }

}
