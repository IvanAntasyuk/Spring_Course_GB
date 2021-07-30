package ru.geekbrains.interfaces;
import org.springframework.data.domain.Page;
import ru.geekbrains.persist.ProductParams;
import ru.geekbrains.persist.Product;
import java.util.List;
import java.util.Optional;

public interface ProductInter {

    List<Product> findAll();

    Page<Product> findWithFilter(ProductParams productParams);

    Optional<Product> findById(Long id);

    void save(Product user);

    void deleteById(Long id);
}