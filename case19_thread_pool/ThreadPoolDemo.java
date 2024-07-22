package case19_thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 饭店的故事：
 * 核心元素一：正式员工数量                                 ------>   核心线程数量                    不能小于0
 * 核心元素二：餐厅最大员工数                               ------>   线程池中最大线程数量             不能小于等于0，最大数量 >= 核心线程数量
 * 核心元素三：临时员工空闲多长时间被辞退（值）               ------>   空闲线程最大存活时间（值）       不能小于0      
 * 核心元素四：临时员工空闲多长时间被辞退（单位）             ------>   空闲时间（单位）                用TimeUnit指定
 * 核心元素五：排队的客户                                   ------>   阻塞队列                       不能为null
 * 核心元素六：从哪里招人                                   ------>   创建线程的方式                  不能为null
 * 核心元素七：当排队人数过多，超出顾客请下次再来（拒绝服务）  ------>   要执行的任务过多时的解决方案     不能为null
 * 
 * 队伍排满了才会创建临时线程，先提交的任务不一定先执行。
 * 临时线程创建数达到最大值，仍有任务提交，则触发拒绝策略。
 * 
 * 拒绝策略：
 * AbortPolicy：丢弃任务并抛出RejectedExecutionException异常。
 * CallerRunsPolicy：直接调用run()方法，跳过线程池来执行。
 * DiscardOldestPolicy：丢弃队列中等待最久的任务，并将当前任务加入队列。
 * DiscardPolicy：不处理任务，直接丢弃。
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
            3, // 核心线程数量，不能小于0
            6, // 线程池中最大线程数量
            60, // 空闲线程最大存活时间（值）
            TimeUnit.SECONDS, // 空闲时间（单位）
            //new LinkedBlockingQueue<Runnable>(), // 阻塞队列
            new ArrayBlockingQueue<Runnable>(3), // 阻塞队列
            Executors.defaultThreadFactory(), // 创建线程的方式
            new ThreadPoolExecutor.AbortPolicy() // 任务过多时的解决方案
        );

        //pool.submit(null)
    }
}
