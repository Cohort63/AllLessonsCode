import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Sergey Bugaenko
 * {@code @date} 19.08.2025
 */

public class ComparatorApp {
    public static void main(String[] args) {

        int[] ints = new int[]{9, 5, 1, 2, 4, 3, 0};

        Arrays.sort(ints);

        System.out.println(Arrays.toString(ints));

        Car[] cars = new Car[5];
        cars[0] = new Car("Alfa", 2021, 120);
        cars[1] = new Car("BMW", 2000, 190);
        cars[2] = new Car("Citroen", 2018, 190);
        cars[3] = new Car("VW", 2021, 250);
        cars[4] = new Car("Ferrari", 2023, 300);

        printCars(cars);

        Arrays.sort(cars);

        printCars(cars);

        CarSpeedComparator  carSpeedComparator = new CarSpeedComparator();

        Arrays.sort(cars, carSpeedComparator);

        printCars(cars);

        Arrays.sort(cars, new Comparator<Car>() {

            @Override
            public int compare(Car c1, Car c2) {
                return c1.getModel().compareTo(c2.getModel());
            }
        });

        // () ->  expression
        // () ->  { statements; }

        printCars(cars);

        Arrays.sort(cars, (c1, c2) -> {
            return c1.getModel().compareTo(c2.getModel());
        });

        Arrays.sort(cars, (c1, c2) -> c1.getModel().compareTo(c2.getModel()));

        Arrays.sort(cars, (c1, c2) -> {
//            int yearCompare = c1.getYear() - c2.getYear();
            int yearCompare = Integer.compare(c1.getYear(), c2.getYear());

            if (yearCompare == 0) {
                return  c2.getModel().compareTo(c1.getModel());
            }

            return yearCompare;
        });



        printCars(cars);

        Comparator<Car> carComparator = Comparator.comparing(car -> car.getYear());

        carComparator = Comparator.comparing(Car::getYear);

        Arrays.sort(cars, carComparator);

        printCars(cars);

        /*
        Второй параметр метода comparing
        Comparator.naturalOrder() - определяет естественный порядок сортировки
        Comparator.reverseOrder() - определяет обратный порядок сортировки
         */

        Arrays.sort(cars, Comparator.comparing(Car::getYear, Comparator.reverseOrder()));

        printCars(cars);

//        cars[4] = new Car(null, 2021, 250);

        Arrays.sort(cars, Comparator.comparing(Car::getModel, Comparator.nullsFirst(String::compareTo)));
        Arrays.sort(cars, Comparator.comparing(Car::getModel, Comparator.nullsLast(Comparator.naturalOrder())));

        printCars(cars);

        // Отсортировать машины по году. Если годы равны, отсортировать по модели в обратном порядке
        Arrays.sort(cars,
                Comparator.comparing(Car::getYear).thenComparing(Car::getModel, Comparator.reverseOrder())
                );

        printCars(cars);
        Arrays.sort(cars,
                Comparator.comparing(Car::getYear).reversed()
                );

        printCars(cars);

        // Отсортировать по модели в обратном порядке, если модели равны по убыванию года выпуска
        Arrays.sort(cars,
                Comparator.comparing(Car::getModel, Comparator.reverseOrder())
                .thenComparing(Car::getYear, Comparator.reverseOrder())
        );

        printCars(cars);

        // Отсортировать машины по году в обратном, если год равен отсортировать по максимальной скорости в прямом

        Arrays.sort(cars, Comparator.comparing(Car::getYear, Comparator.reverseOrder())
                        .thenComparing(Car::getSpeed)
                );


        printCars(cars);





    }

    private static void printCars(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println("============================\n");
    }
}
