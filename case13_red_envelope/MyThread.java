package case13_red_envelope;

import java.math.BigDecimal;
import java.util.Random;

public class MyThread extends Thread {
    
    // 共享数据
    // 100块，分成3个红包
    static BigDecimal money = BigDecimal.valueOf(100);
    static int count = 3;

    // 最小的中奖金额
    static final BigDecimal MIN = BigDecimal.valueOf(0.01);

    @SuppressWarnings("deprecation")
    @Override
    public void run() {
        synchronized(MyThread.class) {
            if (count == 0) {// 红包抢完了
                System.out.println(getName() +"没有抢到红包！");
            } else {
                BigDecimal prize = BigDecimal.ZERO; // 中奖金额（红包抽到的金额）

                // 如果是最后一个红包，就无需随机，剩余所有的钱都是中奖金额
                if (count == 1) {
                    prize = money;
                } else {
                    // 表示第一次、第二次（随机）
                    Random r = new Random();
                    // 第一个红包，最大金额99.98
                    double bounds = money.subtract(BigDecimal.valueOf(count - 1).multiply(prize)).doubleValue();
                    prize = BigDecimal.valueOf(r.nextDouble(bounds)); // jdk17开始，nextDouble()方法可以接收一个参数，表示上界
                }

                prize = prize.setScale(2, BigDecimal.ROUND_HALF_UP); // 四舍五入到两位小数
                if (prize.compareTo(MIN) < 0) {
                    prize = MIN;
                }

                money = money.subtract(prize); // 抽到红包，扣除金额
                count--; // 抽到红包，剩余的红包数量减一  
                System.out.println(getName() + "抢到了" + prize + "元！");
            }
        }
    }
}
