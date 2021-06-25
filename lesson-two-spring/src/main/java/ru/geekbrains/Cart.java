package ru.geekbrains;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int id;
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void showAllProduct () {
        products.forEach(p -> System.out.println(p.getId()+ "\t"
                + p.getName() + "\t" + p.getPrice()));
    }

    public List<Product> listProductsCart () {
        return this.products;
    }

    public void addProduct (Product product) {
        products.add(product);
    }

    public void deleteProduct (Product product) {
        products.remove(product);
    }

    public void setId(int id) {
        this.id = id;
    }
}
