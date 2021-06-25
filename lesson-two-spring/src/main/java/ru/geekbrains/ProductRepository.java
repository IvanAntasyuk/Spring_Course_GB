package ru.geekbrains;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> productList;

    public ProductRepository() {
        this.productList = new ArrayList<>();
        productList.add(new Product(1, "Beer", 2.22));
        productList.add(new Product(2, "Whiskey", 7.10));
        productList.add(new Product(3, "Vine red", 4.10));
        productList.add(new Product(4, "Vodka", 3.12));
        productList.add(new Product(5, "Vine white", 4.90));
    }

    public List<Product> findAll () {
        return new ArrayList<>(productList);
    }

    public Product findProductById (int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void addProduct (Product product) {
        productList.add(product);
    }

}
