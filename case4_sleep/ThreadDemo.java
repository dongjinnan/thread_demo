package case4_sleep;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        
        // 不设置的情况下有默认名字： Thread-X，X为线程编号，从0开始
        // 设置名字：setName()方法或者构造方法

        MyThread t1 = new MyThread("飞机"); 
        MyThread t2 = new MyThread("坦克");

        t1.start();
        t2.start();

        // Thread t = Thread.currentThread();
        // String name = t.getName();
        // System.out.println("当前线程的名字：" + name);

        // System.out.println("111111111");
        // Thread.sleep(5000);
        // System.out.println("222222222");
    }
}