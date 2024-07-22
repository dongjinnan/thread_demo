package case1_yield;
public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            System.out.println(getName() + "@" + i);
            // 让出时间片，让其他线程有机会执行（结果看起来会更均匀一些）
            Thread.yield();
        }
    }
    
}
