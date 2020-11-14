package Thread20201114;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private static AtomicInteger count = new AtomicInteger(0);
 
    public static void add() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(count.incrementAndGet());
        }
    }
 
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    AtomicIntegerTest.add();
                }
            });
            thread.start();
        }
    }
}