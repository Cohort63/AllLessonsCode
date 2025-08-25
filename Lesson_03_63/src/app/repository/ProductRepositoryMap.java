package app.repository;

import app.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

@Repository
public class ProductRepositoryMap implements ProductRepository{

    private Map<Long, Product> database = new HashMap<>();

    public ProductRepositoryMap() {
        initData(); // добавление в мапу продуктов при создании объекта репозитория
    }

    private void initData() {
        database.put(1L, new Product(1L, "Apple", new BigDecimal(90)));
        database.put(2L, new Product(2L, "Banana", new BigDecimal(120)));
        database.put(3L, new Product(3L, "Orange", new BigDecimal(180)));
    }

    @Override
    public Product getById(Long id) {
        return database.getOrDefault(id, null);
    }


}
