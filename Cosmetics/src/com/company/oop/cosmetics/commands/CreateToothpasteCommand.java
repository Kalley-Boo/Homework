package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateToothpasteCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateToothpasteCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.get(0);
        String brandName = parameters.get(1);
        double price = Double.parseDouble(parameters.get(2));
        GenderType genderType = GenderType.valueOf(parameters.get(3).toUpperCase());
        List<String> ingredients = List.of(parameters.get(4).split(", "));

        return createToothpaste(name, brandName, price, genderType, ingredients);
    }

    private String createToothpaste(String name, String brandName, double price, GenderType genderType, List<String> ingredients) {
        if (cosmeticsRepository.productExist(name)) {
            throw new IllegalArgumentException("Product with the same name already exists.");
        }

        cosmeticsRepository.createToothpaste(name, brandName, price, genderType, ingredients);

        return String.format("Toothpaste with name " + name + " was created!");
    }
}