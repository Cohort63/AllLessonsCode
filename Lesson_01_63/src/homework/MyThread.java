package homework;

/**
 * @author Sergey Bugaenko
 * {@code @date} 20.08.2025
 */

/*
Дан диапазон чисел: от 1 до 2_000_000 включительно.
Задача: найти, сколько чисел из этого диапазона делятся нацело на 21 и при этом содержат цифру 3.
Решить данную задачу в один поток.
Решить данную задачу в два потока, разделив между потоками заданный диапазон чисел пополам.
Сравнить результаты двух решений - они должны совпадать.
 */

    // 145342 -> "145342".contains "3"

public class MyThread extends Thread {

    private final int rangeStart;
    private final int rangeEnd;

    public MyThread(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run() {
        for (int i = rangeStart; i <= rangeEnd ; i++) {
            if (i % 21 == 0 && String.valueOf(i).contains("3")) {
                Main.incrementCounter();
            }
        }
    }
}
