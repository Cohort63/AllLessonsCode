package task_01;

/**
 * @author Sergey Bugaenko
 * {@code @date} 19.08.2025
 */

public class Task1 {

    public static void main(String[] args) {

        /*
        Два способа создания потока
        1. Наследование от класса Thread
        2. Реализация интерфейса Runnable
         */


        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();


        // Это не порождает новые потоки
        // Мы получаем просто выполнение кода методов в текущем потоке
//        myThread1.run();
//        myThread2.run();

        // При создании потока наследованием - вызываем метод start()
        // Метод start создает новый поток, в котором будет выполнен набор инструкций,
        // прописанных в методе run
        myThread1.start();


        // При имплементации - сначала создаем объект класса Thread,
        // передаем при создании объект нашего класса, реализовавшего интерфейс Runnable
        // И у созданного объекта типа Thread вызываем метод start()
        Thread thread = new Thread(myThread2);
        // для того, чтобы сделать поток демон-потоком
        thread.setDaemon(true);
        thread.start();




        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
