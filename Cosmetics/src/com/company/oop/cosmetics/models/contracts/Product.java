package com.company.oop.cosmetics.models.contracts;

import com.company.oop.cosmetics.models.enums.GenderType;

import java.util.List;

public interface Product {

    String getName();

    String getBrandName();

    double getPrice();

    GenderType getGenderType();

    String print();

}
