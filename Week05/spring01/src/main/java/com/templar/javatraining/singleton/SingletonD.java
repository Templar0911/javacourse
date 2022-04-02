package com.templar.javatraining.singleton;

/**
 * 静态内部类
 * Java 加载外部类的时候，不会创建内部类的实例，只有在外部类使用到内部类的时候才会创建内部类实例。
 * 优点：延迟加载；线程安全；无锁，效率高
 */
public class SingletonD {

    private SingletonD(){}

    private static class SingletonInner {
        private static final SingletonInner INSTANCE = new SingletonInner();
    }

    public static SingletonInner getInstance() {
        return SingletonInner.INSTANCE;
    }
}
