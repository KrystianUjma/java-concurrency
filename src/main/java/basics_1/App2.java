package basics_1;

class Runner2 implements Runnable{
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " +i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner2());
        Thread t2 = new Thread(new Runner2());

        t1.start();
        t2.start();
    }
}
