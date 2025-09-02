package staticBlock;

/**
 * @author Sergey Bugaenko
 * {@code @date} 02.09.2025
 */

public class StaticBlockDemo {

    static int counter = 5;
    static String[] colors;

    private String title;
    private int capacity;

    // Статический блок инициализации
    // В нем могут быть проинициализированы статические поля класса
    // (присвоение начальных значений)
    // Вызывается он ровно один раз в момент загрузки объекта в JVM (до вызова конструкторов)

    static {
        System.out.println("Static block RUN");
        colors = new String[3];
        colors[0] = "red";
        colors[1] = "yellow";
        colors[2] = "green";
    }

    // НЕ статические блоки инициализации.
    // Выполняются при КАЖДОМ создании объекта класса.
    // Вызываются до конструктора
    {
        System.out.println("NON-static block RUN");
        this.capacity = 100;
    }

    public StaticBlockDemo(String title, int capacity) {
        System.out.println("Constructor run");
        this.title = title;
        this.capacity = capacity;

//        colors = new String[] {"rrr", "reerreer"};
    }

    public StaticBlockDemo(String title) {
        System.out.println("Constructor-2 run");
        this.title = title;
    }

    @Override
    public String toString() {
        return "StaticBlockDemo{" +
                "title='" + title + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
