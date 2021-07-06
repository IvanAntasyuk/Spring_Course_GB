package ru.geekbrains.persist;



public class Product {
    private Integer id;
    private String name;
    private Integer cost;
    private String desc;


    public Product() {
    }

    public Product(String name, Integer cost, String desc) {
        this.name = name;
        this.cost = cost;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
