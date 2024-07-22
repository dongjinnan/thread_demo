package case11_cook_food;

/**
 * 消费者：吃货
 */
public class Foodie extends Thread {

    @Override
    public void run() {
        while(true) {
            synchronized(Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    // 先判断桌子上是否有面条
                    if (Desk.foodFlag == 0) {
                        // 如果没有，等待
                        try {
                            Desk.lock.wait();// 让当前线程跟锁进行绑定
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    } else {
                        // 把吃的总数-1
                        Desk.count--;
                        // 如果有，就吃掉面条
                        System.out.println("吃货在吃面条，还能再吃" + Desk.count + "碗！！！");
                        // 吃完之后，唤醒厨师继续做
                        Desk.lock.notifyAll();
                        // 修改桌子的状态
                        Desk.foodFlag = 0;
                    }
                    
                }
            }
        }
    }
}
