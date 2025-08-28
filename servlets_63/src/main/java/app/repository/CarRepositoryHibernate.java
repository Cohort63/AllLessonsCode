package app.repository;

import app.model.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author Sergey Bugaenko
 * {@code @date} 27.08.2025
 */

public class CarRepositoryHibernate implements CarRepository{


    private EntityManager entityManager;

    public CarRepositoryHibernate() {
        entityManager = new Configuration()
                .configure("hibernate/postgres.cfg.xml")
                .buildSessionFactory().createEntityManager();
    }

    @Override
    public List<Car> getAll() {
        // JPQL - Java Persistence Query Language -
        // SQL -> SELECT * FROM car WHERE brand='BMW'
        // JPQL -> SELECT c FROM Car c WHERE c.brand='BMW'
        // SELECT c FROM Car c -> FROM Car

        return entityManager.createQuery("from Car", Car.class).getResultList();
    }

    @Override
    public Car save(Car car) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(car);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw new RuntimeException(e);
        }
        return car;
    }

    @Override
    public Car getById(long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public Car update(Car dataForUpdate) {
        // id :
        // newPrice:
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();
            Car foundCar = entityManager.find(Car.class, dataForUpdate.getId());
            foundCar.setPrice(dataForUpdate.getPrice());
            transaction.commit();
            return foundCar;

        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Car delete(long id) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Car foundCar = entityManager.find(Car.class, id);
            entityManager.remove(foundCar);
            transaction.commit();
            return foundCar;
            // remove(foundCat)
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw new RuntimeException(e);
        }

    }
}
