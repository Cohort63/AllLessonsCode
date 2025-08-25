package threads;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

public class InterruptExample2 {

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            for (long i = 0; i < Long.MAX_VALUE; i++) {

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Сигнал на прерывание получен, выходим");
                    break;
                }

                // имитация работы
                if (i % 1_000_000_000 == 0) {
                    System.out.println("Обработано: " + i);
                }

            }
        });

        worker.start();
        Thread.sleep(2000);
        worker.interrupt();


    }
}
