package case12_cook_food;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread {

    @SuppressWarnings("rawtypes")
    ArrayBlockingQueue queue;

    public Cook(@SuppressWarnings("rawtypes") ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        while (true) {
            // 不断的把面条放入阻塞队列中
            try {
                queue.put("面条"); // 有锁
                System.out.println("厨师做了一碗面条");// 写在了锁外边
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
