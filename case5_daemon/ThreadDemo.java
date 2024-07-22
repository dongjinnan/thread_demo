package case5_daemon;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.setName("女神");
        t2.setName("备胎");

        // 当其他的非守护线程（女神）执行完毕，守护线程会陆续结束（备胎没有存在的必要了）
        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}