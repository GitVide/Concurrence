package juc.producerandconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Container1<T> {

    final private Queue<T> queue = new LinkedList<>();
    final private int MAX_SIZE = 10;

    public synchronized void put(T t) {
        while (queue.size() >= MAX_SIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.offer(t);
        this.notifyAll();
    }

    public synchronized T get() {
        while (queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = queue.poll();
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        Container1<String> container = new Container1<>();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String s = container.get();
                        System.out.println(Thread.currentThread().getName() + ", 消费了" + s);
                        try{
                            TimeUnit.MILLISECONDS.sleep(600);
                        }catch (InterruptedException e){
                            System.out.println(e);
                        }

                    }

                }
            }, "消费者" + i).start();
        }

        TimeUnit.SECONDS.sleep(1);

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        Random random = new Random();
                        int x = random.nextInt();
                        String s = Thread.currentThread().getName();
                        System.out.println(s + "，生产了： " + x);
                        container.put(x + "");
                        try{
                            TimeUnit.MILLISECONDS.sleep(600);
                        }catch (InterruptedException e){
                            System.out.println(e);
                        }
                    }

                }
            }, "生产者" + i).start();
        }
    }
}
