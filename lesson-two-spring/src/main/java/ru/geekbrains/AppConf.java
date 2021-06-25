package ru.geekbrains;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConf {
    @Bean
    public ProductRepository productRepository () {
        return new ProductRepository();
    }

    @Bean
    @Scope("prototype")
    public Cart cart () {
        return new Cart();
    }
}
