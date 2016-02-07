package interrupting_threads_13;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallable {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting.");

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<?> future = executorService.submit(() -> {
            Random random = new Random();

            for (int i = 0; i < 1E8; i++) {
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Interrupted!");
                    break;
                }
                Math.sin(random.nextDouble());
            }
            return null;
        });

        executorService.shutdown();

        Thread.sleep(500);

        executorService.shutdownNow();
//        future.cancel(true);

        System.out.println("Finished.");
    }
}
