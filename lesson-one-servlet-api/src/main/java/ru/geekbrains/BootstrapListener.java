package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       ServletContext sc =  sce.getServletContext();

        ProductRepository productRepository = new ProductRepository();
        productRepository.save(new Product(1L,"Щётка стеклоочистителя передняя левая"));
        productRepository.save(new Product(2L,"Щётка стеклоочистителя передняя правая"));
        productRepository.save(new Product(3L,"Колодки тормозные задние"));
        productRepository.save(new Product(5L,"Колодки тормозные передни"));
        productRepository.save(new Product(6L,"Прокладка сливной пробки поддона двигателя"));
        productRepository.save(new Product(7L,"Свеча зажигания"));
        productRepository.save(new Product(8L,"Фильтр воздушный"));
        productRepository.save(new Product(9L,"Фильтр масляный"));
        productRepository.save(new Product(10L,"Фильтр салона"));
        sc.setAttribute("productRepository",productRepository);
    }
}
