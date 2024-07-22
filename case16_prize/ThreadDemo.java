package case16_prize;

import java.util.ArrayList;
import java.util.Collections;

/**
 * case15 优化
 */
public class ThreadDemo {
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,10,5,20,50,100,200,500,800,2,80,300,700);

        MyThread t1 = new MyThread(list);
        MyThread t2 = new MyThread(list);
        MyThread t3 = new MyThread(list);
        MyThread t4 = new MyThread(list);
        MyThread t5 = new MyThread(list);

        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");
        t3.setName("抽奖箱3");
        t4.setName("抽奖箱4");
        t5.setName("抽奖箱5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    
    }
}
