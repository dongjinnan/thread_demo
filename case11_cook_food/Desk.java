package case11_cook_food;

/**
 * 控制生产者和消费者的执行
 */
public class Desk {

    // 是否有面条 0：没有 1：有
    public static int foodFlag = 0;

    // 一共能做或能吃的总个数
    public static int count = 10;

    // 锁对象
    public static Object lock = new Object();
    
}
