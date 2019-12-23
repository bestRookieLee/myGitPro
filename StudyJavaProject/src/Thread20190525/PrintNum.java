package Thread20190525;

public class PrintNum implements Runnable{
        private int lastNum;

        public PrintNum (int lastNum) {
            this.lastNum = lastNum;
        }

        @Override
        public void run() {
            Thread t4 = new Thread(new PrintChar('c',40));
            for (int i = 1;i<=lastNum;i++ ){
                System.out.println(" " + i);
                //Thread.yield();
            }
            //如果休眠 即便该线程的优先级最高别的线程也不会等
//            try {
//                for (int i = 1;i<=lastNum;i++ ){
//                    System.out.println(" " + i);
//                    Thread.sleep(1000L);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
}
