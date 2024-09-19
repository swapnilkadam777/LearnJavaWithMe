package Creational.Redistry;

public class Main {
    public static void main(String[] args) {
        // Create a registry
        ProductRegistry registry = new ProductRegistry();

        // Register products
        registry.registerProduct("ProductA", new ConcreteProductA());
        registry.registerProduct("ProductB", new ConcreteProductB());

        // Retrieve and use products
        Product productA = registry.getProduct("ProductA");
        productA.use();  // Output: Using Product A

        Product productB = registry.getProduct("ProductB");
        productB.use();  // Output: Using Product B
    }

}
