package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cart> carts = new ArrayList<>();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);
        System.out.println("Store");
        System.out.println("List product");
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        productRepository.findAll().forEach(p -> System.out.println(p.getId() + "\t"
                + p.getName() + "\t" + p.getPrice()));

        int idCart = 0;

        System.out.println("Create cart -- new");
        System.out.println("<Add Product > add № <cart> and id <Product>");
        System.out.println("<Remove Product > remove № <cart> and id <Product>");
        System.out.println("<Show cart> show and id <cart>");

        Scanner sc = new Scanner(System.in);
        while (true) {
            String command = sc.nextLine();
            if (command.startsWith("new")) {
                Cart cart = context.getBean("cart", Cart.class);
                cart.setId(idCart);
                carts.add(cart);
                System.out.println("Create cart " + idCart);
                idCart++;
            } else if (command.startsWith("add")) {
                String[] commands = command.split(" ");
                int needIdCart = Integer.parseInt(commands[1]);
                int needProduct = Integer.parseInt(commands[2]);
                Cart needCart = carts.get(needIdCart);
                needCart.addProduct(productRepository.findProductById(needProduct));
                System.out.println("Cart № " + needIdCart + " add " + productRepository.findProductById(needProduct).getName());
            } else if (command.startsWith("remove")) {
                String[] commands = command.split(" ");
                int needIdCart = Integer.parseInt(commands[1]);
                int needProduct = Integer.parseInt(commands[2]);
                List<Product> productsInCart = carts.get(needIdCart).listProductsCart();
                for (Product product : productsInCart) {
                    if (product.getId() == needProduct) {
                        carts.get(needIdCart).deleteProduct(product);
                    }
                }
            } else if (command.startsWith("show")) {
                String[] commands = command.split(" ");
                int needIdCart = Integer.parseInt(commands[1]);
                Cart needCart = carts.get(needIdCart);
                needCart.showAllProduct();
            }
        }
    }
}
