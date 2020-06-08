package juc.flowcontoller.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//模拟多人运动，跑步
public class CountDowLatchDemo3 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int no = i + 1;
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    System.out.println("No. " + no + "准备完毕，等待发令枪！");
                    try {
                        begin.await();
                        System.out.println("No. " + no +"开始跑步了");
                        Thread.sleep((long) (Math.random()*10000));
                        end.countDown();
                        System.out.println("No. " + no +"到达终点");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            };
            service.submit(runnable);

        }
        Thread.sleep(3000);
        System.out.println("裁判准备完毕，发令枪响");
        begin.countDown();
        end.await();
        System.out.println("所有运动员到达终点，比赛结束");
        service.shutdown();
    }
}
