package task_04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Sergey Bugaenko
 * {@code @date} 19.08.2025
 */

public class Task4 {

    public static AtomicInteger counter = new AtomicInteger(0);


    public static void main(String[] args) {


        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.start();
        myThread2.start();


        for (int i = 0; i < 1_000_000; i++) {
//            counter.incrementAndGet(); // ++counter
           counter.getAndIncrement(); // counter++;

        }


        try {
            // Таким образом мы просим главный поток остановиться в этом месте
            // и дождаться завершения работы другого потока (в данном случае myThread1)
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("counter: " + counter);
    }
}
