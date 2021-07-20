package ru.geekbrains.persist;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> productPrefix(String prefix){
        return (root,query,builder) -> builder.like(root.get("title"),prefix+"%");
    }

    public static Specification<Product> maxCost(Integer maxCost){
        return (root,query,builder) -> builder.le(root.get("cost"),maxCost);
    }

    public static Specification<Product> minCost(Integer minCost){
        return (root,query,builder) -> builder.le(root.get("cost"),minCost);
    }

}