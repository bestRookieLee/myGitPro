package Thread20190525;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSyncByLock {
    private static class AddAPennyTask implements Runnable{
        private static Account account = new Account();

        public static void main(String[] args) {
            ExecutorService executor = Executors.newCachedThreadPool();
            for(int i=0;i<100;i++){
                executor.execute(new AddAPennyTask());
            }
            executor.shutdown();
            while (!executor.isTerminated()){
            }
        }
        @Override
        public void run() {
//             synchronized (account){
//                 account.deposit(1);
//             }
            account.deposit(1);
            System.out.println("what is balance?" + account.getBalance());
        }
    }

    private static class Account {
        //定义要锁
        /**
         * 这个 ReentrantLock 是 Lock的一个具体实现，用于创建相互排斥的锁，可以创建具有特定的公平策略的锁公平策略值为真
         * 则确保等待时间最长的线程首先获得锁。取值为假的公平策略将锁给任意的等待线程。被多个线程访问的使用公正锁的程序，
         * 其整体性可能比那些使用默认设置的程序差，但是在获取锁且避免资源缺乏时可以有更小的时间变化
         */
        private static Lock lock = new ReentrantLock();
        private int balance = 0 ;
        public int getBalance (){
            return balance;
        }
        public void deposit(int amount){
            lock.lock();
            try {
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }
}
