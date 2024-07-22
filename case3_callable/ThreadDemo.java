package case3_callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        MyCallable mc = new MyCallable();

        FutureTask<Integer> ft = new FutureTask<>(mc);

        Thread t1 = new Thread(ft);
        // Thread t2 = new Thread(ft);

        // t1.setName("线程1");
        // t2.setName("线程2");

        t1.start();
        // t2.start();

        Integer result = ft.get();

        System.out.println("结果：" + result);
    }
}