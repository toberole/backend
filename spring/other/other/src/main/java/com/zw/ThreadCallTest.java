package com.zw;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadCallTest {
    public static ExecutorService exe = Executors.newCachedThreadPool();

    public static int count = 1;
    public static Object pc_lock = new Object();

    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();

        CloneTest cloneTest = new CloneTest();
        cloneTest.setI(333);
        System.out.println(cloneTest);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(cloneTest);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
        CloneTest cloneTest1 = (CloneTest) inputStream.readObject();
        System.out.println(cloneTest1);

        //test8();
        int activeCount;
        while ((activeCount = Thread.activeCount()) > 1) {
            System.out.println("activeCount: " + activeCount);
            Thread.sleep(1000 * 30);
        }

        System.out.println("over");
    }

    private static void test8() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal1.set("threadLocal1 hello1");
                String s = threadLocal1.get();
                System.out.println(s);

                threadLocal2.set("threadLocal2 hello1");
                s = threadLocal2.get();
                System.out.println(s);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal1.set("threadLocal1 world");
                String s = threadLocal1.get();
                System.out.println(s);

                threadLocal2.set("threadLocal2 world");
                s = threadLocal2.get();
                System.out.println(s);
            }
        }).start();
    }

    private static void test7() {
        try {
            //读写锁
            ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
            //获取写锁
            ReentrantReadWriteLock.WriteLock wlock = rwLock.writeLock();
            //获取读锁
            ReentrantReadWriteLock.ReadLock rLock = rwLock.readLock();

            Lock lock = new ReentrantLock();
            lock.tryLock(1000, TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("test7 ......");
        }
    }

    private static void test6() {
        // 生产者
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (pc_lock) {
                        while (count >= 1) {
                            try {
                                pc_lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("生产一个 ++++++");
                        count = 1;
                        pc_lock.notify();
                    }
                }
            }
        }).start();

        // 消费者
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (pc_lock) {
                        while (count < 1) {
                            try {
                                pc_lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("消费一个 ......");
                        count = 0;
                        pc_lock.notify();
                    }
                }
            }
        }).start();
    }

    private static void test5() {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1#run ......");
                synchronized (lock1) {
                    try {
                        Thread.sleep(1000);

                        synchronized (lock2) {
                            System.out.println("thread1 ......");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2#run ......");
                synchronized (lock2) {
                    try {
                        Thread.sleep(1000);

                        synchronized (lock1) {
                            System.out.println("thread2 ......");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    private static void test4() throws Exception {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        Future<Object> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return new Object();
            }
        });
        System.out.println(future.get());
    }

    private static void test3() {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println("lock");
        } finally {
            lock.unlock();
        }
    }

    private static void test2() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread("Hello_" + System.currentTimeMillis());
                        return thread;
                    }
                },
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r);
                    }
                });

        Future<Object> future = threadPoolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return new Object();
            }
        });
        Future<?> future1 = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        try {
            //System.out.println("future1: " + future1.get());

            Object o = future.get();
            System.out.println("future: " + o);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test1() {
        try {
            TaskCallable taskCallable = new TaskCallable();
            Future<Integer> result = exe.submit(taskCallable);
            Integer r = result.get();

            FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Hello Future: " + System.currentTimeMillis();
                }
            });
            exe.submit(futureTask);
            String s = futureTask.get();
            System.out.println(s);

            exe.shutdown();
            System.out.println("call result" + result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class TaskCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("begin ....");
        Thread.sleep(3000);
        return 100;
    }
}
