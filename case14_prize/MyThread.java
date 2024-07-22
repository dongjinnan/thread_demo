package case14_prize;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread {

    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }
    
    @Override
    public void run() {
        while(true) {
            synchronized(MyThread.class) {
                if (list.size() == 0) {// 抽完了
                    break;
                } else {// 继续抽
                    Collections.shuffle(list); // 打乱
                    int prize = list.remove(0); // 抽一个奖品
                    System.out.println(getName() + " 又产生了一个" + prize + "元大奖");
                }
            }

            // 让线程运行的更平均一点
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
