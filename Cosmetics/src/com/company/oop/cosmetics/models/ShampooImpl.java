package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.Shampoo;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;

public class ShampooImpl implements Product, Shampoo {
    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_NAME_MIN_LENGTH = 2;
    public static final int BRAND_NAME_MAX_LENGTH = 10;
    private String name;
    private String brand;
    private double price;
    private GenderType genderType;
    private int milliliters;
    private UsageType usageType;

    public ShampooImpl(String name, String brand, double price,
                       GenderType genderType, int milliliters,
                       UsageType usageType) {
        validateName(name);
        validateBrand(brand);
        validatePrice(price);
        validateMilliliters(milliliters);

        setName(name);
        setBrand(brand);
        setPrice(price);
        setGenderType(genderType);
        setMilliliters(milliliters);
        setUsageType(usageType);
    }//constructor ShampooImpl

    //-------------------------------------functions----------------------------------------
    public String print(){
        return String.format("#%s %s\n #Price: %.2f\n #Gender: %s\n #Milliliters: %d\n #Usage: %s",
                getName(), getBrandName(), getPrice(), getGenderType(), getMillilitres(), getUsageType());
    }//toString overriding
    private void validateName(String name){
        if(name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH){
            throw new IllegalArgumentException("Name should be between 3 and 10 symbols.");
        }
    }//validateName
    private void validateBrand(String brand){
        if(brand.length() < BRAND_NAME_MIN_LENGTH || brand.length() > BRAND_NAME_MAX_LENGTH){
            throw new IllegalArgumentException("Brand should be between 2 and 10 symbols.");
        }
    }//validateBrand
    private void validatePrice(double price){
        if(price < 0){
            throw new IllegalArgumentException("Price should be non negative.");
        }
    }//validatePrice
    private void validateMilliliters(int milliliters){
        if(milliliters < 0){
            throw new IllegalArgumentException("Milliliters should be non negative.");
        }
    }//validateMilliliters
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShampooImpl shampoo = (ShampooImpl) o;
        return getName().equals(shampoo.getName()) &&
                getBrandName().equals(shampoo.getBrandName()) &&
                getPrice() == shampoo.getPrice() &&
                getGenderType().equals(shampoo.getGenderType()) &&
                getMillilitres() == shampoo.getMillilitres() &&
                getUsageType().equals(shampoo.getUsageType());
    }//equals overriding
    //--------------------------------setters and getters-----------------------------------
    public void setName(String name){
        this.name = name;
    }//setName
    public void setBrand(String brand) {
        this.brand = brand;
    }//setBrand
    public void setPrice(double price) {
        this.price = price;
    }//setPrice
    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }//setGenderType
    public void setMilliliters(int milliliters) {
        this.milliliters = milliliters;
    }//setMilliliters
    public void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }//setUsageType
    public String getName() {
        return name;
    }
    public String getBrandName() {
        return brand;
    }
    public double getPrice() {
        return price;
    }
    public GenderType getGenderType() {
        return genderType;
    }
    public int getMillilitres() {
        return milliliters;
    }
    public UsageType getUsageType() {
        return usageType;
    }//getUsageType
}
