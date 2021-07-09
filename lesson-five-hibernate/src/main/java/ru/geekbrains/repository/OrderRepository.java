package ru.geekbrains.repository;

import ru.geekbrains.entity.Client;
import ru.geekbrains.entity.Order;
import ru.geekbrains.entity.Product;
import ru.geekbrains.service.MyEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrderRepository  extends MyEntityManager {

    public OrderRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }
    public void addPoductInOrder(Long clientId ,Long productId){
        Client client = executeForEntityManger(em -> em.getReference(Client.class, clientId));
        Product product = executeForEntityManger(em -> em.getReference(Product.class, productId));
        Order order = new Order(client,product);
        executeInTransaction(em-> em.persist(order));
    }
    public List<Product> clientProducts(Long clientId){
        return executeForEntityManger(em-> em
                .createQuery("select p from Order o join fetch  Product p on p=o.product where  o.client.id=:id")
                .setParameter("id",clientId)
                .getResultList());
    }

    public List<Client> whoBuyProduct(Long productId){
        return executeForEntityManger(em-> em
                .createQuery("select c from Order o join fetch  Client c on c=o.client where  o.product.id=:id")
                .setParameter("id",productId)
                .getResultList());
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
