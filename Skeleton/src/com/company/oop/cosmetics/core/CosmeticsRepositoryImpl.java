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
        for(Product product : products){
            if(product.getName().equalsIgnoreCase(productName)){
                return product;
            }
        }
        throw new IllegalArgumentException("Product " + productName + " does not exist!");
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        for(Category category : categories){
            if(category.getName().equalsIgnoreCase(categoryName)){
                return category;
            }
        }
        throw new IllegalArgumentException("Category " + categoryName + " does not exist!");
    }

    @Override
    public void createCategory(String categoryName) {
        if(!categoryExist(categoryName)){
            Category category = new Category(categoryName);
            categories.add(category);
        }
    }

    @Override
    public void createProduct(String name, String brand, double price, GenderType gender) {
        Product product = new Product(name, brand, price, gender);
        products.add(product);
    }

    @Override
    public boolean categoryExist(String categoryName) {
        for(Category category : categories){
            if(category.getName().equalsIgnoreCase(categoryName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean productExist(String productName) {
        for(Product product : products){
            if(product.getName().equalsIgnoreCase(productName)){
                return true;
            }
        }
        return false;
    }
}
