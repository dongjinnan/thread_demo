package case18_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        
        //ExecutorService pool1 =Executors.newCachedThreadPool(); // 没有上限的线程池
        ExecutorService pool1 = Executors.newFixedThreadPool(3); // 有上限的线程池

        // 提交任务
        pool1.submit(new MyRunnable());

        //Thread.sleep(1000);
        
        pool1.submit(new MyRunnable());

        //Thread.sleep(1000);
        pool1.submit(new MyRunnable());
        //Thread.sleep(1000);
        pool1.submit(new MyRunnable());
        //Thread.sleep(1000);
        pool1.submit(new MyRunnable());

        // 销毁线程池 线程池一般不销毁
        //pool1.shutdown();
    }
}
