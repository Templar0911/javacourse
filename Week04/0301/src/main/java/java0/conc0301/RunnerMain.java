
package java0.conc0301;

import java.io.IOException;

public class RunnerMain {

    public static void main(String[] args) throws IOException {

        Runner1 runner1 = new Runner1();
        Thread thread1 = new Thread(runner1);

        Runner2 runner2 = new Runner2();
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();

        thread2.interrupt();  // i = true

        System.out.println("1111：" + Thread.activeCount());
        System.out.println("activeGroupCount: " + Thread.currentThread().getThreadGroup().activeGroupCount());
        System.out.println("activeCount: " + Thread.currentThread().getThreadGroup().activeCount());
        
        Thread.currentThread().getThreadGroup().list();
        System.out.println("parent activeGroupCount：" + Thread.currentThread().getThreadGroup().getParent().activeGroupCount());
        System.out.println("parent activeCount：" + Thread.currentThread().getThreadGroup().getParent().activeCount());
        Thread.currentThread().getThreadGroup().getParent().list();
    
        
    }
}
