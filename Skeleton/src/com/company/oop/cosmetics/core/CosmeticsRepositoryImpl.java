package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.Product;
import com.company.oop.cosmetics.models.ShoppingCart;

import java.util.ArrayList;

public class CosmeticsRepositoryImpl implements CosmeticsRepository {

    private final ArrayList<Product> products;
    private final ArrayList<Category> categories;
    private final ShoppingCart shoppingCart;

    public CosmeticsRepositoryImpl() {
        products = new ArrayList<>();
        categories = new ArrayList<>();

        shoppingCart = new ShoppingCart();
    }

    @Override
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public ArrayList<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    @Override
    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product findProductByName(String productName) {
        /**
         * Hint: You have to go through every product and see if one has name equal to productName.
         *       If not, "throw new IllegalArgumentException("Product %s does not exist!");"
         */
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        /**
         * Hint: You have to go through every category and see if one has name equal to categoryName.
         *       If not, "throw new IllegalArgumentException("Category %s does not exist!");"
         */
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void createCategory(String categoryName) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void createProduct(String name, String brand, double price, GenderType gender) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean categoryExist(String categoryName) {
        /**
         * Hint: You have to go through every category and see if one has name equal to categoryName.
         *       If there is one, return true. If not, return false.
         */
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean productExist(String productName) {
        /**
         * Hint: You have to go through every product and see if one has name equal to productName.
         *       If there is one, return true. If not, return false.
         */
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
