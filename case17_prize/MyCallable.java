package case17_prize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class MyCallable implements Callable<Integer> {

    ArrayList<Integer> list;

    public MyCallable(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        ArrayList<Integer> boxList = new ArrayList<>();

        while(true) {
            synchronized(MyCallable.class) {
                if (list.size() == 0) {// 抽完了
                    System.out.println(
                        Thread.currentThread().getName() + "总共产生了" + boxList.size() + "个奖项。分别为：" 
                        + String.join(",", boxList.stream().map(Object::toString).collect(Collectors.toList())) 
                        + "，最高奖项为" + Collections.max(boxList) + "元，总计额为" 
                        + boxList.stream().reduce(0,Integer::sum) + "元。");

                    break;
                } else {// 继续抽
                    Collections.shuffle(list); // 打乱
                    int prize = list.remove(0); // 抽一个奖品
                    //System.out.println(getName() + " 又产生了一个" + prize + "元大奖");
                    boxList.add(prize);
                }
            }

            // 让线程运行的更平均一点
            Thread.sleep(10);
        }

        // 把集合中的最大值返回
        if (boxList.size() == 0) {
            return null;
        } else {
            return Collections.max(boxList);
        }
    }
}
