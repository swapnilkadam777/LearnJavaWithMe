package InterfaceSegrigationPrinciple.ImproveCode;

public class Dog implements Eater, Swimmable {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void swim() {
        System.out.println("Dog is swimming.");
    }
}
