package case13_red_envelope;

/**
 * 抢红包：100块，分成了3个红包，有5个人去抢
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();        
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();

        t1.setName("小A");
        t2.setName("小QQ");
        t3.setName("小诗诗");
        t4.setName("小哈哈");
        t5.setName("小卡卡");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
