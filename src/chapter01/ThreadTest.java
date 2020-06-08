package chapter01;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                    System.out.println("捕获了中断！");
                }
                System.out.println("这是线程"+ Thread.currentThread().getName());
            }
        },"Thread1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                    System.out.println("捕获了中断！");
                }
                System.out.println("这是线程"+ Thread.currentThread().getName());
            }
        },"Thread2");
        thread1.start();
        thread2.start();
        thread1.join();

        System.out.println(Thread.currentThread().getName());
    }
}
