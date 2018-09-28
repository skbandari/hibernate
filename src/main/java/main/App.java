package main;

import config.AppContextConfig;
import model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repo.ProductDAO;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContextConfig.class);
        ProductDAO dao = context.getBean(ProductDAO.class);

        Product p1 = new Product("Touchpad", 500d);
        Product p2 = new Product("Laptop", 700d);
        Product p3 = new Product("Smart phone", 1000d);

        dao.add(p1);
        dao.add(p2);
        dao.add(p3);

        for(Product p : dao.getAll()) {
            System.out.println(p.getDescription() + " :" + p.getPrice());
        }

        ((ConfigurableApplicationContext) context).close();

    }
}
