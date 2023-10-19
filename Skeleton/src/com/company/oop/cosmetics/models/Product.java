package com.company.oop.cosmetics.models;

import java.util.Objects;

public class Product {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_MIN_LENGTH = 2;
    public static final int BRAND_MAX_LENGTH = 10;
    private String name;
    private String brand;
    private double price;
    private GenderType gender;

//-----------------------------constructor---------------------------------------
    public Product(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }
//-----------------------------setters and getters---------------------------------
    public void setName(String name){
        if(name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH){
            throw new IllegalArgumentException("Name should be between 3 and 10 symbols.");
        }
        this.name = name;
    }

    public void setBrand(String brand){
        if(brand.length() < BRAND_MIN_LENGTH || brand.length() > BRAND_MAX_LENGTH){
            throw new IllegalArgumentException("Brand should be between 2 and 10 symbols.");
        }
        this.brand = brand;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("Price should be non negative.");
        }
        this.price = price;
    }

    public String getName() {
       return name;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public GenderType getGender() {
    return gender;
    }
//-----------------------------------------methods--------------------------------------------
    public String print() {
        return String.format("#%s %s\n#Price: %.2f\n#Gender: %s", name, brand, price, gender);
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Product product = (Product) p;
        return Double.compare(this.getPrice(), product.getPrice()) == 0 &&
                Objects.equals(this.getName(), product.getName()) &&
                Objects.equals(this.getBrand(), product.getBrand()) &&
                this.getGender() == product.getGender();
    }
    
}
