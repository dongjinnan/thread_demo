package case4_sleep;

public class MyThread extends Thread{

    public MyThread(){
    }

    public MyThread(String name){
        super(name);
    }
    
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(getName() + "@" + i);
        }
    }
}
