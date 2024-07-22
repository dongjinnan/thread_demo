package case11_cook_food;

public class ThreadDemo {
    public static void main(String[] args) {
        
        Cook c = new Cook();
        Foodie f = new Foodie();

        c.setName("厨师");
        f.setName("吃货");

        c.start();
        f.start();
    }
}
