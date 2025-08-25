package task_02;

/**
 * @author Sergey Bugaenko
 * {@code @date} 19.08.2025
 */

public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            Task2.counter++;
        }
    }
}
