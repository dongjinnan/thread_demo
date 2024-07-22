package case12_cook_food;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread {

    ArrayBlockingQueue<String> queue;

    public Foodie(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }   

    @Override
    public void run() {
        while (true) {
            // 不断的从阻塞队列中获取面条
            try {
                String food = queue.take(); // 有锁
                System.out.println(food); // 写在了锁外边
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
