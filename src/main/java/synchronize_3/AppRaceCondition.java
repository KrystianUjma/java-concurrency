package synchronize_3;

public class AppRaceCondition {

    private int count;

    public static void main(String[] args) {
        AppRaceCondition app = new AppRaceCondition();
        app.doWork();
    }

    private void doWork() {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
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

}
