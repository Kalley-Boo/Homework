package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;

public class CreamImpl implements Product, Cream {
    public static final int NAME_MIN_LEN = 3;
    public static final int NAME_MAX_LEN = 15;
    private String name;
    private String brandName;
    private double price;
    private GenderType genderType;
    private ScentType scentType;

    public CreamImpl(String name, String brandName,
                     double price, GenderType genderType,
                     ScentType scentType){
        validateName(name);
        validateBrandName(brandName);
        validatePrice(price);

        setName(name);
        setBrandName(brandName);
        setPrice(price);
        setGenderType(genderType);
        setScent(scentType);
    }
    //----------------------------------functions---------------------------------------
    public String print(){
        return String.format("#%s %s\n #Price: %.2f\n #Gender: %s\n #Scent: %s",
                getName(), getBrandName(), getPrice(), getGenderType(), getScent());

    }

    public void validateName(String name){
        if(name.length() < NAME_MIN_LEN || name.length() > NAME_MAX_LEN){
            throw new IllegalArgumentException("Name should be between 3 and 15 symbols.");
        }
    }//validateName
    public void validateBrandName(String brandName){
        if(brandName.length() < NAME_MIN_LEN || brandName.length() > NAME_MAX_LEN){
            throw new IllegalArgumentException("Brand should be between 3 and 15 symbols.");
        }
    }//validateBrandName
    public void validatePrice(double price){
        if(price < 0){
            throw new IllegalArgumentException("Price should be non negative.");
        }
    }//validatePrice
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreamImpl cream = (CreamImpl) o;
        return getName().equals(cream.getName()) &&
                getBrandName().equals(cream.getBrandName()) &&
                getPrice() == cream.getPrice() &&
                getGenderType().equals(cream.getGenderType()) &&
                getScent().equals(cream.getScent());
    }//equals overriding
    //-----------------------------setters and getters----------------------------------
    public void setName(String name) {
        this.name = name;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }
    public void setScent(ScentType scentType) {
        this.scentType = scentType;
    }

    public String getName() {
        return name;
    }
    public String getBrandName() {
        return brandName;
    }
    public double getPrice() {
        return price;
    }
    public GenderType getGenderType() {
        return genderType;
    }
    public ScentType getScent() {
        return scentType;
    }
}
