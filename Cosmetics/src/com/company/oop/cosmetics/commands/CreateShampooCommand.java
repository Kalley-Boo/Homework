package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateShampooCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateShampooCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.get(0);
        String brandName = parameters.get(1);
        double price = Double.parseDouble(parameters.get(2));
        GenderType genderType = GenderType.valueOf(parameters.get(3).toUpperCase());
        int milliliters = Integer.parseInt(parameters.get(4));
        UsageType usageType = UsageType.valueOf(parameters.get(5).toUpperCase());

        return createShampoo(name, brandName, price, genderType, milliliters, usageType);
    }

    private String createShampoo(String name, String brandName, double price, GenderType genderType, int milliliters, UsageType usageType) {
        if (cosmeticsRepository.productExist(name)) {
            throw new IllegalArgumentException("Product with the same name already exists.");
        }

        cosmeticsRepository.createShampoo(name, brandName, price, genderType, milliliters, usageType);

        return String.format("Shampoo with name " + name + " was created!");
    }

}
