package chapter03;

import java.util.stream.IntStream;

public class ThreadYield {
    private static Thread create(int index) {
        return new Thread(() -> {
            if (index == 0)
                Thread.yield();
            System.out.println(index);
        });
    }

    public static void main(String[] args) {
        IntStream.range(0, 2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }
}
