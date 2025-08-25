package app.code;

import app.staff.administration.Director;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Sergey Bugaenko
 * {@code @date} 20.08.2025
 */

public class ApplicationWithSpring {

    public static void main(String[] args) {

        // Запуск приложения со Spring-ом

        // Получаем объект контекста
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext("app.config");

        // class Class

        // Из контекста получаем Bean директора
        Director director = context.getBean(Director.class);

        director.manageCompany();



    }
}
