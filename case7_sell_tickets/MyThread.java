package case7_sell_tickets;

public class MyThread extends Thread {

    // static 表示这个类所有的对象都共享ticket数据
    static int ticket = 0; // 票数 0~99

    // 锁对象，一定要唯一，所以要加static关键字
    // static Object obj = new Object(); 
    
    @Override
    public void run() {
        while (true) {
            // 加锁，保证线程安全 （相当于上厕所）
            // this 非静态，不唯一。 MyThread.class 字节码文件唯一
            synchronized (MyThread.class) {
            // synchronized (obj) {
                if (ticket < 100) {
                    // sleep 防止票卖的太快。 相当于人干活不能一直干，中间偶尔需要休息一下
                    // 一号窗口sleep的时候，并不会释放锁，所以其他窗口也没有卖票
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    // 这里的ticket++不是原子操作，可能被其他线程抢走，导致票数不准确
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票！！！");
                } else {
                    break;
                }
            }
        }
    }
}
