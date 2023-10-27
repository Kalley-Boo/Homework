package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.Toothpaste;
import com.company.oop.cosmetics.models.enums.GenderType;

import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl implements Product, Toothpaste {
    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_NAME_MIN_LENGTH = 2;
    public static final int BRAND_NAME_MAX_LENGTH = 10;
    private String name;
    private String brandName;
    private double price;
    private GenderType genderType;
    private List<String> ingredients;

    public ToothpasteImpl(String name, String brandName,
                          double price, GenderType genderType,
                          List<String> ingredients) {
        validateName(name);
        validateBrandName(brandName);
        validatePrice(price);

        setName(name);
        setBrandName(brandName);
        setPrice(price);
        setGenderType(genderType);
        setIngredients(ingredients);
    }//constructor ToothpasteImpl

    //-----------------------------------------functions-----------------------------------------

    public void validateName(String name){
        if(name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH){
            throw new IllegalArgumentException("Name should be between 3 and 10 symbols.");
        }
    }//validateName
    public void validateBrandName(String brandName) {
        if (brandName.length() < BRAND_NAME_MIN_LENGTH || brandName.length() > BRAND_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Brand should be between 2 and 10 symbols.");
        }
    }//validateBrandName
    public void validatePrice(double price){
        if(price < 0){
            throw new IllegalArgumentException("Price should be non negative.");
        }
    }//validatePrice
    @Override
    public String print() {
        return String.format("#%s %s\n #Price: %.2f\n #Gender: %s\n #Ingredients: %s",
                getName(), getBrandName(), getPrice(),getGenderType(), getIngredients());
    }//print
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToothpasteImpl toothpaste = (ToothpasteImpl) o;
        return getName().equals(toothpaste.getName()) &&
                getBrandName().equals(toothpaste.getBrandName()) &&
                getPrice() == toothpaste.getPrice() &&
                this.getGenderType().equals(toothpaste.getGenderType()) &&
                getIngredients().equals(toothpaste.getIngredients());
    }
    //------------------------------------setters and getters------------------------------------
    public void setName(String name) {
        this.name = name;
    }//setName
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }//setBrandName
    public void setPrice(double price) {
        this.price = price;
    }//setPrice
    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }//setGenderType
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }//setIngredients

    public String getName(){
        return name;
    }//getName
    public String getBrandName(){
        return brandName;
    }//getBrandName
    public double getPrice(){
        return price;
    }//getPrice
    public GenderType getGenderType(){
        return genderType;
    }//getGenderTypе
    public List<String> getIngredients(){
        return new ArrayList<>(this.ingredients);
    }
}
