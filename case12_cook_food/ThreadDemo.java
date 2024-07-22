package case12_cook_food;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 利用阻塞队列完成生产者和消费者的代码
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 生产者和消费者必须使用同一个阻塞队列
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        Cook c = new Cook(queue);
        Foodie f = new Foodie(queue);

        c.start();
        f.start();
    }
}
