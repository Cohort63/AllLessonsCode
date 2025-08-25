package app.service;

import app.model.Product;
import app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

@PropertySource("classpath:application.properties")
@Service
public class ProductServiceImpl implements ProductService {

    /*
    1. @Autowired на поле класса
    2. Внедрение через конструктор
    3. Внедрение через сеттер
     */


    private ProductRepository repository;

    private String articlePrefix;

    public ProductServiceImpl(
            ProductRepository repository,
            @Value("${article.prefix}") String articlePrefix) {
        this.repository = repository;
        this.articlePrefix = articlePrefix;
    }

    @Override
    public Product getById(Long id) {
        Product product = repository.getById(id);
        setArticle(product);
        return product;
    }

    // Banana, id=2 ->Art-B-2
    private void setArticle(Product product) {
        String article = String.format("%s-%s-%d",
                articlePrefix,
                product.getTitle().charAt(0),
                product.getId()
                );
        product.setArticle(article);
    }

//    public static void main(String[] args) {
//        int x;
//        x = 10;
//        x++;
//
//
//    }
}
