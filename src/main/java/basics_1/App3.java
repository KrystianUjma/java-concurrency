package basics_1;

import java.util.stream.IntStream;

public class App3 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            IntStream.range(0, 10).forEach(System.out::println);
        });

        t1.start();
    }
}
