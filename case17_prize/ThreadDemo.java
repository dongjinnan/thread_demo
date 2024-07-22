package case17_prize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 在case16基础上，追加打印：在此次抽奖过程中，抽奖箱2中产生了最大奖项，该奖项金额为800元。
 * 难点：不清楚最大奖项在哪个线程中被抽走，不清楚哪个线程先执行完
 * 核心逻辑：获取线程抽奖的最大值
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,10,5,20,50,100,200,500,800,2,80,300,700);

        MyCallable mc = new MyCallable(list);
        
        FutureTask<Integer> ft1 = new FutureTask<>(mc);
        FutureTask<Integer> ft2 = new FutureTask<>(mc);
        
        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);

        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");
        
        t1.start();
        t2.start();

        Integer max1 = ft1.get();
        Integer max2 = ft2.get();

        if (max1 > max2) {
            System.out.println("在此次抽奖过程中，抽奖箱1中产生了最大奖项，该奖项金额为" + max1+ "元。");
        } else {
            System.out.println("在此次抽奖过程中，抽奖箱2中产生了最大奖项，该奖项金额为" + max2+ "元。");
        }
    }
}
