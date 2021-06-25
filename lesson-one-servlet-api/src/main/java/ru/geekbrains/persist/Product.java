package ru.geekbrains.persist;

public class Product {
    private Long id;
    private String name;
    private int cost;
    private String disc;

    public Product(Long id, String name,int cost,String disc) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.disc  =disc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
}
