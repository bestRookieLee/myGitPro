package Thread20190525;

public class TestTask {
    public static void main(String[] args) {
        TaskClass task = new TaskClass();
        //创建线程，设置名称
        Thread thread = new Thread(task, "Thread_name");
        //启动线程
        thread.start();
    }
}
