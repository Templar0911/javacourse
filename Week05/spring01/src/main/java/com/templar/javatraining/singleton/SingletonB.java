package com.templar.javatraining.singleton;

/**
 * 懒汉
 * 优点：延迟加载；线程安全
 * 缺点：效率低
 */
public class SingletonB {

    private static SingletonB INSTANCE = null;

    private SingletonB() {}

    public static synchronized SingletonB getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new SingletonB();
        }
        return INSTANCE;
    }
}
