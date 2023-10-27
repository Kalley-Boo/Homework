package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateCreamCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateCreamCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.get(0);
        String brandName = parameters.get(1);
        double price = Double.parseDouble(parameters.get(2));
        GenderType genderType = GenderType.valueOf(parameters.get(3).toUpperCase());
        ScentType scentType = ScentType.valueOf(parameters.get(4).toUpperCase());

        return createCream(name, brandName, price, genderType, scentType);
    }

    private String createCream(String name, String brandName, double price, GenderType genderType, ScentType scentType) {
        if (cosmeticsRepository.productExist(name)) {
            throw new IllegalArgumentException("Product with the same name already exists.");
        }

        cosmeticsRepository.createCream(name, brandName, price, genderType, scentType);

        return String.format("Cream with name " + name + " was created!");
    }
}
