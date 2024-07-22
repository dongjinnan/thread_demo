package case14_prize;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 有一个抽奖池，该抽奖池中存放了奖励的金额，该抽奖池中的奖项为{10,5,20,50,100,200,500,800,2,80,300,700}；
 * 创建两个抽奖箱（线程），设置线程名称分别为“抽奖箱1”，“抽奖箱2”
 * 随机从抽奖池中获取奖项元素并打印在控制台上，格式如下：
 * 抽奖箱1 又产生了一个10元大奖
 * 抽奖箱2 又产生了一个100元大奖
 * ......
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
