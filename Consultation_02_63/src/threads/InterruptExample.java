package threads;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

public class InterruptExample {

    public static void main(String[] args) throws InterruptedException {

        Thread worked = new Thread(
                // имплементация на ходу функционального интерфейса Runnable
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.println("Working...");

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            System.out.println("Поток прерван во время сна");
                            Thread.currentThread().interrupt(); // восстановить флаг
                        }
                    }

                    System.out.println("Поток завершает работу");
                }
        );

        worked.start();
        Thread.sleep(2000);
        worked.interrupt();

//        sleepMe(2000);
    }

    private static void sleepMe(int seconds) throws InterruptedException{
        Thread.sleep(seconds);
    }
}
