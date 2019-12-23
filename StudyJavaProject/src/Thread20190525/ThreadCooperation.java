package Thread20190525;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
    private static Account account = new Account();
    private static int withdraw = 0;
    private static int waitForDeposit = 0;
    private static int DepositNum = 0;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new WithdrawTask());
        executor.execute(new DepositTask());
        executor.shutdown();
        System.out.println("thread 1\t\tthread2 \t\tBalance");
    }
    public static class DepositTask implements Runnable{
        private int i = 50;
        @Override
        public void run() {
            while (i>0) {
                try {
                    account.deposit((int)(Math.random()*10)+1);
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                i--;
            }
        }
    }

    public static class WithdrawTask implements Runnable{
        private int i = 50;
        @Override
        public void run() {
            while (i>0){
                account.withdraw((int)(Math.random()*10)+1);
                i--;
            }
        }
    }

    private static class Account {
        private static Lock lock = new ReentrantLock();
        /**
         * 使用条件实现线程间的通信。
         * 一个线程可以指定在某种条件下该做什么
         * newDeposit 就是这个条件
         */
        private static Condition newDeposit = lock.newCondition();
        private int balance = 0;
        public int getBalance(){
            return balance;
        }

        /**
         * 从账户里面取钱
         * @param amount
         */
        public void withdraw (int amount){
            lock.lock();
            try {
                while(balance<amount){

                    waitForDeposit++;
                    System.out.println( "\t\t\twithdraw " + amount + "\t\t\twait for deposit " + waitForDeposit);
                    //让当前线程进行等待
                    if(DepositNum<50){
                        newDeposit.await();
                    }else{
                        newDeposit.signal();
                    }

                }
                balance -= amount;
                withdraw++;
                System.out.println("\t\t\twithdraw " + amount + "\t\t\t" + getBalance()+" "+ withdraw);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        /**
         * 往账户里面存钱
         * @param amount
         */
        public void deposit(int amount){
            lock.lock();
            DepositNum++;
            try {
                balance += amount;
                System.out.println("deposit " + amount + "\t\t\t\t\t\t" + getBalance()+" "+DepositNum);
                newDeposit.signalAll();
            }finally {
                //这个要加，锁一直握在这个方法手中
                lock.unlock();
            }
        }
    }
}
