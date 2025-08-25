package app.service;

import app.model.Product;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

public interface ProductService {

    Product getById(Long id);
}
