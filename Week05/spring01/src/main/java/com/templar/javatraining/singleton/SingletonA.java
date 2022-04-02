package com.templar.javatraining.singleton;

/**
 * 饿汉
 * 优点：线程安全；无锁
 * 缺点：非延迟加载
 */
public class SingletonA {

    private static final SingletonA INSTANCE = new SingletonA();

    private SingletonA() {
    }

    public static SingletonA getInstance() {
        return INSTANCE;
    }
}
