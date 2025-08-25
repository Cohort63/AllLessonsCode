package client;

import app.controller.ProductController;
import app.model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

public class Client {
    public static void main(String[] args) {

        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext("app");

        ProductController controller = context.getBean(ProductController.class);

        Product product = controller.getById(3L);

        System.out.println(product);

    }
}
