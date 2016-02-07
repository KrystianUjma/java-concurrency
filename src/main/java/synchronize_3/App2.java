package synchronize_3;

public class App2 {

    private int count;

    public static void main(String[] args) {
        App2 app = new App2();
        app.doWork();
    }

    private void doWork() {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);

    }

    public synchronized void increment(){
        count++;
    }

}
