import java.util.concurrent.TimeUnit;

/**
 * Create by wl on 2020/9/4
 */
public class A {
    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        System.out.println("set开始执行");
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        this.balance = balance;
        System.out.println("set结束执行");

    }

    public /**synchronized**/ double getBalance(String name) {
        return this.balance;
    }


    public static void main(String[] args) {
        A a = new A();
        new Thread(()->a.set("zhangsan", 100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));
    }
}
