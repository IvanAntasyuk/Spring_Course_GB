package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.entity.Client;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ClientRepository;
import ru.geekbrains.repository.OrderRepository;
import ru.geekbrains.repository.ProductRepository;


import javax.persistence.EntityManagerFactory;

public class Run {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

//        ProductRepository productRepository = new ProductRepository(emFactory);
//
//        ClientRepository clientRepository = new ClientRepository(emFactory);

        OrderRepository orderRepository = new OrderRepository(emFactory);
        orderRepository.addPoductInOrder(1l, 7l);
        System.out.println(orderRepository.clientProducts(1l));

    }
}
