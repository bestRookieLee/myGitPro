package Thread20190525;

public class volatile_learn {
    private volatile int inc = 0;  //volatile保证修改一个共享变量时，立即将更改后的共享变量从工作缓存刷回主存。
    public void increase(){
        this.inc++;
    }
    public static void main(String[] args) {
        final volatile_learn sharedObject = new volatile_learn();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<100;j++){
                        sharedObject.increase();
                        //Thread.yield();
                    }
                    System.out.println(sharedObject.inc);
                };
            }.start();
        }
    }
}
