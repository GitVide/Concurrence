package chapter01;
/**
 * 代码清单1-1TryConcurrency.java
 */

import java.util.concurrent.TimeUnit;

public class TryJconsloe {
    public static void  main(String[] args){
        new Thread(){
            @Override
            public void run(){
                enjoyMusic();
//                browseNews();
            }
        }.start();
        browseNews();
    }
    /**
     * Browse the lastest new
     */
    private static void browseNews(){
        for(;;){
            System.out.println("Uh-huh-hu, the good news!");
            sleep(1);
        }
    }
    /**
     * Listening and enjoy the music.
     */
    private static void enjoyMusic(){
        for(;;){
            System.out.println("Listen to the music!");
            sleep(1);
        }
    }
    /**
     * 模拟等待，忽略异常
     * @param seconds
     */
    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
