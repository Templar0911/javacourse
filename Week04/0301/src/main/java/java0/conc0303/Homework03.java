package java0.conc0303;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class Homework03 {

    private static int r1 = 0;
    private static int r2 = 0;
    private static int r3 = 0;
    private static int r5 = 0;
    private static int r6 = 0;
    private static int r7 = 0;
    private static int r8 = 0;
    private static int r9 = 0;

    public static void main(String[] args) {
        Homework03 home = new Homework03();

        // 方法一
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                r1 = 1;
            }
        });
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法一获得结果r1 = " + r1);
        assert (r1 == 1);

        // 方法二
        Thread t2 = home.new Thread2();
        t2.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法二获得结果r2 = " + r2);
        assert (r2 == 1);

        // 方法三
        Thread3 t3 = home.new Thread3();
        new Thread(t3).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法三获得结果r3 = " + r3);
        assert (r3 == 1);

        // 方法四
        Thread4 t4 = home.new Thread4();
        FutureTask<Integer> futureTask4 = new FutureTask<Integer>(t4);
        new Thread(futureTask4).start();
        int r4 = 0;
        try {
            r4 = futureTask4.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("方法四获得结果r4 = " + r4);
        assert (r4 == 1);

        // 方法五
        Thread t5 = home.new Thread5();
        t5.start();
        try {
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法五获得结果r5 = " + r5);
        assert (r5 == 1);

        // 方法六
        Object l6 = new Object();
        Thread t6 = home.new Thread6(l6);
        t6.start();
        synchronized (l6) {
            System.out.println("main线程获取锁");
            while (r6 == 0) {
                try {
                    l6.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("方法六获得结果r6 = " + r6);
        assert (r6 == 1);

        // 方法七
        Lock l7 = new ReentrantLock();
        Condition c7 = l7.newCondition();
        Thread t7 = home.new Thread7(l7, c7);
        t7.start();
        l7.lock();
        try {
            while (r7 == 0) {
                c7.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            l7.unlock();
        }
        System.out.println("方法七获得结果r7 = " + r7);
        assert (r7 == 1);

        // 方法八
        Thread t8 = home.new Thread8(Thread.currentThread());
        t8.start();
        LockSupport.park();
        System.out.println("方法八获得结果r8 = " + r8);
        assert (r8 == 1);

        // 方法九
        CountDownLatch latch9 = new CountDownLatch(1);
        Thread t9 = home.new Thread9(latch9);
        t9.start();
        try {
            latch9.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法九获得结果r9 = " + r9);
        assert (r9 == 1);

        // 方法十
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        int r10 = 0;
        Result result10 = home.new Result(r10);
        Future<Result> future10 = executorService.submit(home.new Thread10(result10), result10);
        try {
            r10 = future10.get().getR();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("方法十获得结果r10 = " + r10);
        assert (r10 == 1);

        // 方法十一
        FutureTask<Integer> futureTask11 = new FutureTask<Integer>(()->1);
        Thread t11 = new Thread(futureTask11);
        t11.start();
        int r11 = 0;
        try {
            r11 = futureTask11.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("方法十一获得结果r11 = " + r11);
        assert (r11 == 1);

    }

    class Thread2 extends Thread {
        @Override
        public void run() {
            r2 = 1;
        }
    }

    class Thread3 implements Runnable {
        @Override
        public void run() {
            r3 = 1;
        }
    }

    class Thread4 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return 1;
        }
    }

    class Thread5 extends Thread {
        @Override
        public void run() {
            r5 = 1;
        }
    }

    class Thread6 extends Thread {
        private Object lockObj;

        public Thread6(Object lockObj) {
            this.lockObj = lockObj;
        }

        @Override
        public void run() {
            synchronized (lockObj) {
                System.out.println("t6线程获取锁");
                r6 = 1;
                lockObj.notifyAll();
            }
        }
    }

    class Thread7 extends Thread {
        private Lock lock;
        private Condition condition;

        public Thread7(Lock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            lock.lock();
            r7 = 1;
            condition.signal();
            lock.unlock();
        }
    }

    class Thread8 extends Thread {
        private Thread mainThread;

        public Thread8(Thread mainThread) {
            this.mainThread = mainThread;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(500);
                r8 = 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LockSupport.unpark(mainThread);
            }
        }
    }

    class Thread9 extends Thread {
        private CountDownLatch latch;

        public Thread9(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            r9 = 1;
            latch.countDown();
        }
    }

    class Result {
        private int r;

        public Result(int r) {
            this.r = r;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }
    }

    class Thread10 implements Runnable {
        private Result result;

        public Thread10(Result result) {
            this.result = result;
        }

        @Override
        public void run() {
            this.result.setR(1);
        }
    }

}
