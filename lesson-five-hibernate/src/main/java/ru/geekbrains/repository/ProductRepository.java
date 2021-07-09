package ru.geekbrains.repository;

import ru.geekbrains.entity.Product;
import ru.geekbrains.service.MyEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ProductRepository extends MyEntityManager {

    public ProductRepository (EntityManagerFactory emFactory){
        this.emFactory=emFactory;
    }

    public List<Product> getListAllProducts() {
        return executeForEntityManger(em ->em.createQuery("select p from Product p").getResultList());
    }

    public Product findById (Long id){
        return executeForEntityManger(em-> em.find(Product.class,id));
    }

    public void saveOrUpdateProduct(Product product) {
        executeInTransaction(em->em.merge(product));
    }

    public void deleteProduct(long id) {
        Product delProd= executeForEntityManger(em -> em.getReference(Product.class, id));
        executeInTransaction(em-> em.remove(delProd));
    }

    @Override
    protected <R> R executeForEntityManger(Function<EntityManager, R> function) {
        return super.executeForEntityManger(function);
    }

    @Override
    protected void executeInTransaction(Consumer<EntityManager> consumer) {
        super.executeInTransaction(consumer);
    }
}

