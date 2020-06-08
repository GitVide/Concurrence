package juc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    static ReentrantLock reentrantLock= new ReentrantLock();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    reentrantLock.lock();
                    System.out.println(""+Thread.currentThread().getName()+"抢占到锁了");
                }finally {
                    reentrantLock.unlock();
                }

                try{
                    reentrantLock.lock();
                    System.out.println(""+Thread.currentThread().getName()+"再次抢占到锁了");
                }finally {
                    reentrantLock.unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    reentrantLock.lock();
                    System.out.println(""+Thread.currentThread().getName()+"抢占到锁了");
                }finally {
                    reentrantLock.unlock();
                }
            }
        }).start();
    }
}
