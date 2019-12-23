package Thread20190525;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSync {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0;i<100;i++){
            executor.execute(new AddPennyTask());
        }
        executor.shutdown();
        while (!executor.isTerminated()){

        }
        System.out.println("balance is " + account.getBalance() );
    }
    private static class AddPennyTask implements Runnable{
        @Override
        public void run() {
            //synchronized(account){
                new Account().deposit(1);
            //}
        }
    }
    private static class Account {
        private Lock lock = new ReentrantLock();
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public  void deposit(int amount){
            //synchronized(account){lock

            int newBalance = 0;
            try {
                lock.lock();
                newBalance = balance + amount;
                balance = newBalance;
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
//                try {
//                    //Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            //}
        }
    }
}
