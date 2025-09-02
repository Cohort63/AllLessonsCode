package cars;

/**
 * @author Sergey Bugaenko
 * {@code @date} 02.09.2025
 */

public class CarApp {

    public static void main(String[] args) {

        System.out.println("Static variable: " + Car.totalCars);

        Car car = new Car("BMW", 200);

        System.out.println("BMW после создания 1 машины: " + car);

        Car vw = new Car("VW", 300);

        System.out.println(vw);

        System.out.println("BMW после создания 2 машины: " + car);

        System.out.println("Static variable: " + Car.totalCars);

        //Я могу обратиться к статике от имени конкретного объекта
        // Плохая практика. Так делать не рекомендуется
//        System.out.println("vw.totalCars: "  + vw.totalCars);

        // static применим только к полям или методам класса
//            static int x;

    }
}
