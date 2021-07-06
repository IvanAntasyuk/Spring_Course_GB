package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.entity.Product;


import javax.persistence.EntityManagerFactory;

public class ProductDao {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
// insert
        ProductRepository rp = new ProductRepository(emFactory);
        rp.saveOrUpdateProduct(new Product("Glass", 250));
        rp.saveOrUpdateProduct(new Product("Fork", 100));
        rp.saveOrUpdateProduct(new Product("Spoon", 99));
        rp.saveOrUpdateProduct(new Product("knife", 110));
//delete
        rp.deleteProduct(1);

//find by id
        Product p = rp.findById(3l);
        System.out.println(p);
//find all
        System.out.println(rp.getListAllProducts());


    }
}
