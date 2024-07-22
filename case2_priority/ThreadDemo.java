package case2_priority;
public class ThreadDemo {
    public static void main(String[] args) {
        
        MyRun mr = new MyRun();

        Thread t1 = new Thread(mr, "飞机");
        Thread t2 = new Thread(mr, "坦克");

        // t1.setName("线程1");
        // t2.setName("线程2");

        // System.out.println(t1.getPriority()); // 不设置的情况下默认优先级为5
        // System.out.println(t2.getPriority());

        // System.out.println(Thread.currentThread().getPriority());

        // 不绝对好用，概率问题
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}