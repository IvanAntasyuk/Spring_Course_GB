package ru.geekbrains.service;

import javax.persistence.EntityManagerFactory;
import java.util.function.Consumer;
import java.util.function.Function;


public class MyEntityManager {

    protected EntityManagerFactory emFactory;

    protected  <R> R executeForEntityManger(Function<javax.persistence.EntityManager, R> function){
        javax.persistence.EntityManager em = emFactory.createEntityManager();
        try{
            return function.apply(em);
        }finally {
            em.close();
        }
    }

    protected void executeInTransaction (Consumer<javax.persistence.EntityManager> consumer){
        javax.persistence.EntityManager em = emFactory.createEntityManager();
        try{
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }
}
