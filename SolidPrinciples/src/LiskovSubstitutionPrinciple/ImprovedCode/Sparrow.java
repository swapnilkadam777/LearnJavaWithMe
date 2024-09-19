package LiskovSubstitutionPrinciple.ImprovedCode;

public class Sparrow extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying.");
    }
    @Override
    public void makeSound() {
        System.out.println("Sparrow sound.");
    }
}