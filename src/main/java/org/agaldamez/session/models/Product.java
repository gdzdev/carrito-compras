package org.agaldamez.session.models;

import java.time.LocalDate;

public class Product {

    private Long id;
    private String name;
    private Categoria type;
    private int price;
    private String sku;
    private LocalDate fecha;

    public Product() {}

    public Product(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, Categoria type, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Product(Long id, String name, String type, int price) {
        this.id = id;
        this.name = name;
        Categoria categoria = new Categoria();
        categoria.setNombre(type);
        this.type = categoria;
        this.price = price;
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

    public Categoria getType() {
        return type;
    }

    public void setType(Categoria type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", type: '" + type + '\'' +
                ", price: " + price +
                '}';
    }
}

