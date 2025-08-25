/**
 * @author Sergey Bugaenko
 * {@code @date} 19.08.2025
 */

public class Car implements Comparable<Car> {
    private String model;
    private int year;
    private int speed;

    public Car(String model, int year, int speed) {
        this.model = model;
        this.year = year;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", speed=" + speed +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int compareTo(Car car) {
        return this.year - car.year;
    }

    // a - b ->

    /*
    a vs b
    a < b -> меньше 0
    a > b -> больше 0
    a == b -> 0
     */
}
