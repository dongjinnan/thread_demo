package case15_prize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class MyThread extends Thread {

    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    static ArrayList<Integer> list1 = new ArrayList<Integer>();
    static ArrayList<Integer> list2 = new ArrayList<Integer>();
    
    @Override
    public void run() {
        while(true) {
            synchronized(MyThread.class) {
                if (list.size() == 0) {// 抽完了
                    if ("抽奖箱1".equals(getName())) {
                        System.out.println(
                            "抽奖箱1总共产生了" + list1.size() + "个奖项。分别为：" 
                            + String.join(",", list1.stream().map(Object::toString).collect(Collectors.toList())) 
                            + "，最高奖项为" + Collections.max(list1) + "元，总计额为" 
                            + list1.stream().reduce(0,Integer::sum) + "元。");

                    } else if ("抽奖箱2".equals(getName())){
                        System.out.println(
                            "抽奖箱2总共产生了" + list2.size() + "个奖项。分别为：" 
                            + String.join(",", list2.stream().map(Object::toString).collect(Collectors.toList())) 
                            + "，最高奖项为" + Collections.max(list2) + "元，总计额为" 
                            + list2.stream().reduce(0,Integer::sum) + "元。");
                    }
                    break;
                } else {// 继续抽
                    Collections.shuffle(list); // 打乱
                    int prize = list.remove(0); // 抽一个奖品
                    //System.out.println(getName() + " 又产生了一个" + prize + "元大奖");
                    if ("抽奖箱1".equals(getName())) {
                        list1.add(prize);
                    } else if ("抽奖箱2".equals(getName())){
                        list2.add(prize);
                    }
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
