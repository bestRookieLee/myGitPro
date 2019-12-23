package Thread20190525;

public class no_volatile {
    private volatile  boolean flag = false;  //标志某个资源是否空闲
    public void doSomethind(){
        while(!flag){
            System.out.println("the resource is free ,let us do something");
        }
        if(flag){
            System.out.println("the resource is busy ,let us stop!");
        }
    }
    public static void main(String[] args) throws Exception {
        final no_volatile sharedObject = new no_volatile();

        new Thread(){
            public void run() {
                sharedObject.doSomethind();
            };
        }.start();

        //Thread.sleep(30);
        new Thread(){
            public void run() {
                sharedObject.flag=true;
                System.out.println("thread-b start");
            };
        }.start();
    }
}