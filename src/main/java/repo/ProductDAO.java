package repo;

import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public class ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public ProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Product> getAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Product").list();
    }

    @Transactional(readOnly = false)
    public void add(Product product) {
        Session session = sessionFactory.openSession();
        session.save(product); //does not result in insert until tx is committed
        //JPA Version
        //session.persist(product);
    }

}
