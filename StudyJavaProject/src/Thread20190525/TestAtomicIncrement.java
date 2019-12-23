package Thread20190525;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicIncrement {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());
    }
}
