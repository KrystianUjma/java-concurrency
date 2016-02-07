package semaphores_11;

import java.util.concurrent.Semaphore;

public class SemaphoreSimple {

    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(0);

        sem.acquire();
        sem.release();

        System.out.println("Available permits " + sem.availablePermits());
    }
}
