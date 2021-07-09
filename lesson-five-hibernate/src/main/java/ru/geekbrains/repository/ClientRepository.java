package ru.geekbrains.repository;


import ru.geekbrains.entity.Client;
import ru.geekbrains.entity.Product;
import ru.geekbrains.service.MyEntityManager;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ClientRepository extends MyEntityManager {

    public ClientRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public void saveOrUpdateClient(Client client) {
        executeInTransaction(em -> em.merge(client));
    }

    public List<Client> getListAllClients() {
        return executeForEntityManger(em -> em.createQuery("select c from Client c").getResultList());
    }

    public Client findById(Long id) {
        return executeForEntityManger(em -> em.find(Client.class, id));
    }

    public void deleteProduct(long id) {
       Client delClient = executeForEntityManger(em -> em.getReference(Client.class, id));
        executeInTransaction(em-> em.remove(delClient));
    }


    @Override
    protected <R> R executeForEntityManger(Function<javax.persistence.EntityManager, R> function) {
        return super.executeForEntityManger(function);
    }

    @Override
    protected void executeInTransaction(Consumer<javax.persistence.EntityManager> consumer) {
        super.executeInTransaction(consumer);
    }
}
