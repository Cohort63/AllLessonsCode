package app.repository;

import app.model.Product;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

public interface ProductRepository {

    Product getById(Long id);
}
