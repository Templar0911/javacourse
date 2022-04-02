package com.templar.javatraining.singleton;

/**
 * 双重检测
 * 在 Java 1.4 及更早的版本中因为指令重排，可能会导致 Singleton 对象被 new 出来，并且赋值给 INSTANCE 之后，还没来得及初始化，就被另一个线程使用了。
 * 故需要给INSTANCE变量增加volatile修饰符，以禁止指令重排。
 * 而高版本的 Java 已在 JDK 内部解决了这个问题。
 * 优点：延迟加载；线程安全；锁的颗粒度更细，效率较懒汉高。
 */
public class SingletonC {

    private static SingletonC INSTANCE = null;

    private SingletonC() {}

    public static SingletonC getInstance() {
        if (null == INSTANCE) {
            synchronized (SingletonC.class) {
                if (null == INSTANCE) {
                    INSTANCE = new SingletonC();
                }
            }
        }
        return INSTANCE;
    }
}
