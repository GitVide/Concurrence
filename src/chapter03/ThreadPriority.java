package chapter03;

public class ThreadPriority {
    public static void main(String[] args){
        Thread thread1 = new Thread(
                () -> {
                    while (true){
                        System.out.println("t1");
                    }
                }
        );
        thread1.setPriority(3);
        Thread thread2 = new Thread(
                () -> {
                    while (true){
                        System.out.println("t2");
                    }
                }
        );
        thread2.setPriority(10);
        thread1.start();
        thread2.start();
    }
}
