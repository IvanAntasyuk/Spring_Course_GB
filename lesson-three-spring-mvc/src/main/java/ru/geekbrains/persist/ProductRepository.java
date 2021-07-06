package ru.geekbrains.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class ProductRepository {

    private Map<Integer, Product> productMap = new ConcurrentHashMap<>();
    private AtomicInteger identity = new AtomicInteger(0);

    @PostConstruct
    public void init(){
        this.insert(new Product("Щётка стеклоочистителя передняя левая",100,"Новый"));
        this.insert(new Product("Щётка стеклоочистителя передняя правая",90,"Новый"));
        this.insert(new Product("Колодки тормозные задние",60,"БУ"));
        this.insert(new Product("Колодки тормозные передни",76,"БУ"));
        this.insert(new Product("Прокладка сливной пробки поддона двигателя",10,"БУ"));
        this.insert(new Product("Свеча зажигания",25,"БУ"));
        this.insert(new Product("Фильтр воздушный",11,"Новый"));
        this.insert(new Product("Фильтр масляный",9,"Новый"));
        this.insert(new Product("Фильтр салона",55,"Новый"));
    }


    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public Optional <Product> findById(int id) {
        return Optional.ofNullable(productMap.get(id));
    }

    public void insert(Product product) {
        Integer id = identity.incrementAndGet();
        product.setId(id);
        productMap.put(id, product);
    }

    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

    public void delete(int id) {
        productMap.remove(id);
    }
}
