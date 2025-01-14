package case11_cook_food;

/**
 * 生产者：厨师
 */
public class Cook extends Thread {

    @Override
    public void run() {
        while(true) {
            synchronized(Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    // 判断桌子上是否有食物
                    if (Desk.foodFlag == 1) {
                        // 如果有，就等待
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    } else {
                        // 如果没有，就制作食物
                        System.out.println("厨师做了一碗面条");
                        // 修改桌子上的食物状态
                        Desk.foodFlag = 1;
                        // 叫醒等待的消费者开吃
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
