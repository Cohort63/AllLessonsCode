package app.repository;

import app.model.Car;

import java.util.List;

/**
 * @author Sergey Bugaenko
 * {@code @date} 22.08.2025
 */

public interface CarRepository {

    List<Car> getAll();

    Car save(Car car);

    Car getById(long id);

    Car update(Car car);

    Car delete(long id);
}
