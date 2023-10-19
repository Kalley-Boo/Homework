package com.company.oop.cosmetics.models;

import java.util.ArrayList;

public class Category {
    public static final int NAME_MIN_LENGTH = 2;
    public static final int NAME_MAX_LENGTH = 15;
    private String name;
    private ArrayList<Product> products;

//---------------------------------constructor---------------------------------------
    public Category(String name) {
        setName(name);
        this.products = new ArrayList<>();
    }
//---------------------------------setters and getters--------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name){
        if(name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH){
            throw new IllegalArgumentException("Name should be between 2 and 15 symbols.");
        }
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        if(!products.remove(product)){
            throw new IllegalArgumentException("Product not found in category.");
        }
    }
    
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append("#Category: ").append(name).append("\n");
        if(products.isEmpty()){
            result.append(" #No product in this category");
        } else {
            for(Product product : products){
                result.append(" #").append(product.getName()).append(" ").append(product.getBrand()).append("\n");
                result.append(" #Price: ").append(product.getPrice()).append("\n");
                result.append(" #Gender: ").append(product.getGender()).append("\n");
                result.append(" ===\n");
            }
        }
        return result.toString();
    }
    
}
