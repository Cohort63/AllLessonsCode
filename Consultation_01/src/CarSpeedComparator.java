import java.util.Comparator;

/**
 * @author Sergey Bugaenko
 * {@code @date} 19.08.2025
 */

public class CarSpeedComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        return c1.getSpeed() - c2.getSpeed();
    }
}
