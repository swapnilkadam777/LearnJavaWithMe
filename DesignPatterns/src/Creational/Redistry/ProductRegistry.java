package Creational.Redistry;

import java.util.HashMap;
import java.util.Map;

public class ProductRegistry {
    private Map<String, Product> products = new HashMap<>();

    public void registerProduct(String key, Product product) {
        products.put(key, product);
    }

    public Product getProduct(String key) {
        return products.get(key);
    }
}