package cars;

import java.util.Arrays;

/**
 * @author Sergey Bugaenko
 * {@code @date} 02.09.2025
 */

// Статические члены класса имеют доступ (видят) ТОЛЬКО статический контент

public class StaticExample {

    // non-static поле класса (переменная)
    int x;

    // static поле класса
    static int staticY;

    // статический метод
    public static void staticMethod() {
        // Статика видит только статику
//        x++; нет доступа к не-статическом полю
        staticY++; // доступ к статическому полю есть

        // Мы можем вызывать ТОЛЬКО статические методы
        // nonStaticMethod();

        // Ключевое слово this не доступно в статик-методе
        //  this.x;

        System.out.println("Вызываем статический метод");
    }

    // НЕ-статически метод
    public void nonStaticMethod() {
        // У не-статического метода есть доступ КО ВСЕМ членам класса.
        x++; // не статика доступа
        staticY++; // статика тоже доступна

        // можем вызывать статические и не-статические методы
        staticMethod();

        System.out.println("Обычный метод");
    }




    // Метод main статический
    public static void main(String[] args) {

       //  x = 10; // Ошибка компиляции. У статики нет доступа к НЕ-статик переменной

        staticY = 10;
        System.out.println(staticY);

        StaticExample.staticMethod();

        StaticExample staticExample = new StaticExample();
        staticExample.nonStaticMethod();


    }
}
