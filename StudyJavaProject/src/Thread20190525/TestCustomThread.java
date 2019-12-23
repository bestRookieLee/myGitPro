package Thread20190525;

public class TestCustomThread {
    public static void main(String[] args) {
        CustomThread thread = new CustomThread();
        thread.start();

        CustomThread thread1 = new CustomThread();
        thread1.start();
    }
}
