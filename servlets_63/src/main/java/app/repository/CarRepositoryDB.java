package app.repository;

import app.constants.Constants;
import app.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static app.constants.Constants.*;

/**
 * @author Sergey Bugaenko
 * {@code @date} 26.08.2025
 */

public class CarRepositoryDB  implements CarRepository{

    private Connection getConnection() {

        // jdbc:postgresql://localhost:5432/g_63_cars?user=postgres&password=pos1234
        try {
            // Подгружаем в память драйвер БД
            Class.forName(DB_DRIVER_PATH);

            String dbUrl = String.format("%s%s?user=%s&password=%s",
                    DB_ADDRESS, DB_NAME, DB_USER, DB_PASSWORD);

            return DriverManager.getConnection(dbUrl);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> getAll() {
        try (Connection connection = getConnection()) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return List.of();
    }

    @Override
    public Car save(Car car) {

        try (Connection connection = getConnection()) {

            // INSERT INTO car (brand, price, year) VALUES ('Toyota', 35000, 2023);

            String query = String.format("INSERT INTO car (brand, price, year) VALUES ('%s', %s, %d);",
                    car.getBrand(), car.getPrice(), car.getYear());

            Statement statement = connection.createStatement();

            // statement.execute() - для внесения изменений в БД
            // statement.executeQuery() - для получения данных

            // Просим в БД сохранить автомобиль и вернуть автоматически сгенерированный ключ
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);

            // TODO - выковырять id из statement

            return car;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public Car getById(long id) {
        try (Connection connection = getConnection()) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Car update(Car car) {
        try (Connection connection = getConnection()) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Car delete(long id) {

        try (Connection connection = getConnection()) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
