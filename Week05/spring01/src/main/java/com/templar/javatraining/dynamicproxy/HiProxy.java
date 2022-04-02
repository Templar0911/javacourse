package com.templar.javatraining.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HiProxy {

    public static void main(String[] args) {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Hi, " + args[0]);
                return null;
            }
        };

        Hi hi = (Hi) Proxy.newProxyInstance(Hi.class.getClassLoader(), new Class[]{Hi.class}, invocationHandler);
        hi.say("yangbo");
    }

}
