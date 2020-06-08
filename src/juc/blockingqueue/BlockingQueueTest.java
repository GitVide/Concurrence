package juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {


    public static void main(String[] args) {
        final BlockingQueue<String> blockingqueue = new ArrayBlockingQueue<String>(3);
        Producer producer = new Producer(blockingqueue);
        Customer customer = new Customer(blockingqueue);
        new Thread(producer).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(customer).start();
    }
}

class Producer implements Runnable {
    BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("来了十个候选人");
        for (int i = 0; i < 10; i++) {

            String candidate = "Candidate " + i;

            try {
                blockingQueue.put(candidate);
                System.out.println(candidate+"安排好了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            blockingQueue.put("stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Customer implements Runnable {
    BlockingQueue<String> blockingQueue;

    public Customer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        String msg;
        try {
            while (!(msg = blockingQueue.take()).equals("stop")) {
                System.out.println(msg + "已经面试完成！");
                //Thread.sleep(1000);

            }
            System.out.println("所有候选人已经面试完成!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
