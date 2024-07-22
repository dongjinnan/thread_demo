package case15_prize;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 在case14基础上继续完成如下需求：
 *    每次抽的过程中，不打印，抽完时一次性打印（随机）
 *    抽奖箱1总共产生了6个奖项。分别为：10,20,100,500,2,300，最高奖项为500元，总计额为932元。
 *    抽奖箱2总共产生了6个奖项。分别为：5,50,200,800,80,700，最高奖项为800元，总计额为1835元。
 */
public class ThreadDemo {
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,10,5,20,50,100,200,500,800,2,80,300,700);

        MyThread t1 = new MyThread(list);
        MyThread t2 = new MyThread(list);

        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");

        t1.start();
        t2.start();
    }
}
