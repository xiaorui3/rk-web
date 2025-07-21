package com.xiaorui.factory;

public class UseFactory {
    public factory am(String name){
        if (name.equals("猫")){
            return new Cat();
        }else if(name.equals("狗")){
            return new Dog();
        }
        else {
            return null;
        }
    }
}
