package producer_consumer_7.wait_notify;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

    private LinkedList<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {

        int value = 0;

        while (true) {
            synchronized (lock) {
                while (queue.size() == LIMIT){
                    lock.wait();
                }

                queue.add(value++);
                lock.notify();
            }
        }

    }

    public void consume() throws InterruptedException {

        Random random = new Random();

        while (true) {
            synchronized (lock) {

                while (queue.size() == 0){
                    lock.wait();
                }

                System.out.print("List size is: " + queue.size());
                int value = queue.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
            }

            Thread.sleep(random.nextInt(1000));
        }

    }
}
