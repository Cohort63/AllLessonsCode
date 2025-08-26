package app.repository;

import app.model.Car;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Sergey Bugaenko
 * {@code @date} 22.08.2025
 */

public class CarRepositoryMap implements CarRepository{

    private Map<Long, Car> database = new HashMap<>();
    private long currentId;

    public CarRepositoryMap() {
        initData();
    }

    private void initData() {
        save(new Car("VW", new BigDecimal(15000), 2015));
        save(new Car("Mazda", new BigDecimal(30000), 2022));
        save(new Car("Ford", new BigDecimal(40000), 2024));
    }

    @Override
    public List<Car> getAll() {
        return  database.values().stream().toList();
//       return new ArrayList<>(database.values());
    }

    @Override
    public Car save(Car car) {
        car.setId(++currentId);
        database.put(car.getId(), car);
        return car;
    }

    @Override
    public Car getById(long id) {
        return database.getOrDefault(id, null);
    }

    @Override
    public Car update(Car car) {
        Long id = car.getId();
        BigDecimal newPrice = car.getPrice();

        // Добавить проверки

        Car carToUpdate = database.getOrDefault(id, null);
        if (carToUpdate == null) return null;

        carToUpdate.setPrice(newPrice);

        return carToUpdate;
    }

    @Override
    public Car delete(long id) {
       return database.remove(id);
    }
}














