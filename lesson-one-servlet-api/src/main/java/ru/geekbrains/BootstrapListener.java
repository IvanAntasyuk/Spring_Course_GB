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
        productRepository.save(new Product(1L,"Щётка стеклоочистителя передняя левая",100,"New"));
        productRepository.save(new Product(2L,"Щётка стеклоочистителя передняя правая",90,"New"));
        productRepository.save(new Product(3L,"Колодки тормозные задние",60,"New"));
        productRepository.save(new Product(5L,"Колодки тормозные передни",76,"New"));
        productRepository.save(new Product(6L,"Прокладка сливной пробки поддона двигателя",10,"New"));
        productRepository.save(new Product(7L,"Свеча зажигания",25,"New"));
        productRepository.save(new Product(8L,"Фильтр воздушный",11,"New"));
        productRepository.save(new Product(9L,"Фильтр масляный",9,"New"));
        productRepository.save(new Product(10L,"Фильтр салона",55,"New"));
        sc.setAttribute("productRepository",productRepository);
    }
}
