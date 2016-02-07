package interrupting_threads_13;

import java.util.Random;

public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting.");

        Thread t = new Thread(() -> {
            Random random = new Random();

            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("We've been interrupted");
                }
//                if(Thread.currentThread().isInterrupted()){
//                    System.out.println("Interrupted!");
//                    break;
//                }
                Math.sin(random.nextDouble());
            }
        });


        t.start();

        Thread.sleep(500);

        t.interrupt();

        t.join();

        System.out.println("Finished.");
    }
}
