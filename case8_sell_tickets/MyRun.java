package case8_sell_tickets;

public class MyRun implements Runnable {

    int ticket = 0;

    @Override
    public void run() {
        
        while (true) {
            synchronized (MyRun.class) {
                if (ticket == 100) {
                    break;
                } else {
                    ticket++;
                    System.out.println(Thread.currentThread().getName() + "在卖第" + ticket + "张票！！！");
                }
            }
        }
    }
    
}
