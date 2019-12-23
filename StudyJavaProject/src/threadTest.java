import Thread20190525.PrintChar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class threadTest {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(15, 15, 3000, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(5), r -> new Thread(r, "component-info"));
        //pool.execute(new PrintChar('a',100));
        pool.submit(new PrintChar('a',100));
        pool.submit(new PrintChar('b',100));
    }
}
