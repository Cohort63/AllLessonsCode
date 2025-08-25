package app.controller;

import app.model.Product;
import app.service.ProductService;
import org.springframework.stereotype.Component;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

@Component
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public Product getById(Long id) {
        return service.getById(id);
    }
}
