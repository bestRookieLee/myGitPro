package Thread20190525;

public class TaskDemo {
    public static void main(String[] args) {
        Runnable printA = new PrintChar('a',100);
        Runnable printB = new PrintChar('b',100);
        Runnable print100 = new PrintNum(100);

        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        thread1.start();
        thread2.start();
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread3.start();
    }
}
