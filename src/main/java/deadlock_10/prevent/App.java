package deadlock_10.prevent;

public class App {

    public static void main(String[] args) throws InterruptedException {
        final Runner runner = new Runner();

        Thread t1 = new Thread(() -> {
            try {
                runner.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"first");

        Thread t2 = new Thread(() -> {
            try {
                runner.secondThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"second");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner.finished();
    }
}
