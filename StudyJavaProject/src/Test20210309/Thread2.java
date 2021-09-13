package Test20210309;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Thread2 {
    Object oushu = new Object();
    Object jishu = new Object();
    private int max;
    public AtomicInteger status = new AtomicInteger(1);


    public Thread2(int max) {
        this.max = max;
    }

    public static void main(String[] args) {
        Thread2 thread2 = new Thread2(1000);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(thread2.new myPrint("oushu", 0));
        executorService.submit(thread2.new myPrint("jishu", 1));
        executorService.shutdown();
    }

    class myPrint implements Runnable{
        private String name;
        private int type;

        public myPrint(String name, int type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public void run() {
            if(type == 1){

               while (status.get() <= max){
                   synchronized (oushu) {
                        if(status.get() % 2 ==0){
                            //有必要？
                        }else{
                            System.out.println("thread"+ Thread.currentThread().getId() + "-" + name + "-" + status.getAndIncrement());
                        }
                   }
                }
            }else{

               while (status.get() <= max) {
                    synchronized (oushu) {
                        if (status.get() % 2 != 0) {
                            //有必要吗？
                        } else {
                            System.out.println("thread"+ Thread.currentThread().getId() + "-" + name + "-" + status.getAndIncrement());
                        }
                    }
                }
            }
        }
    }
}
