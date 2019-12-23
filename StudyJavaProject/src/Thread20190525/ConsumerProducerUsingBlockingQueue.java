package Thread20190525;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 直接使用消息队列就能实现
 * 生产者存数据，消费者取数据的场景
 */
public class ConsumerProducerUsingBlockingQueue {
    //构造函数必须有参数 定义长度
    private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();

        while (true) {
            if (executor.isTerminated()) {
                System.out.println("结束了！");
                Iterator<Integer> it = buffer.iterator();
                while (it.hasNext()){
                    System.out.println(it.next());
                }
                break;
            }
        }
    }
    /**
     * 生产
     */
    public static class ProducerTask implements Runnable{
        private int count = 8;
        @Override
        public void run() {
            try {
                int i = 1;
                while(count > 0){
                    System.out.println("Producer writes " + i);
                    buffer.put(i++);
                    Thread.sleep((int)(Math.random()*1000));
                    count--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ConsumerTask implements Runnable{
        private int count = 8;
        @Override
        public void run() {
            try {
                while (count>0){
                    System.out.println("\t\t\tConsumer reads " + buffer.take());
                    Thread.sleep((int)(Math.random()*1000));
                    count--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
