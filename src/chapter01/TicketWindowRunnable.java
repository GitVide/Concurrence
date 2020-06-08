package chapter01;

public class TicketWindowRunnable implements Runnable {
    private int index=1;
    private final static int MAX=500;
    @Override
    public void run(){
        while(index<=MAX){
            System.out.println(Thread.currentThread().getName()+"的号码是："+(index++));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        final TicketWindowRunnable task=new TicketWindowRunnable();
        Thread t1=new Thread(task,"一号窗口");
        Thread t2=new Thread(task,"二号窗口");
        Thread t3=new Thread(task,"二号窗口");
        Thread t4=new Thread(task,"四号窗口");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
