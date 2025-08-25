package homework;

/**
 * @author Sergey Bugaenko
 * {@code @date} 20.08.2025
 */

public class Main {

    private static int counter;

    public static synchronized void incrementCounter (){
        counter++;
    }

    public static void main(String[] args) {

        singleThreadSolution();
        counter = 0;
        twoThreadsSolution();
        counter = 0;
        multiThreadSolution();

    }

    private static void singleThreadSolution() {
        MyThread myThread = new MyThread(1, 2_000_000);

        myThread.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value with single thread: " + counter);
    }

    private static void twoThreadsSolution() {

        MyThread myThread1 = new MyThread(1, 1_000_000);
        MyThread myThread2 = new MyThread(1_000_001, 2_000_000);

        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value with two threads: " + counter);

    }

    private static void multiThreadSolution() {

        MyThread myThread1 = new MyThread(1, 500_000);
        MyThread myThread2 = new MyThread(500_001, 1_000_000);
        MyThread myThread3 = new MyThread(1_000_001, 1_500_000);
        MyThread myThread4 = new MyThread(1_500_001, 2_000_000);

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();

        try {
            myThread1.join();
            myThread2.join();
            myThread3.join();
            myThread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value with multi threads: " + counter);
    }
}
