package InterfaceSegrigationPrinciple.ImproveCode;

public class Fish implements Eater, Swimmable {
    @Override
    public void eat() {
        System.out.println("Fish is eating.");
    }

    @Override
    public void swim() {
        System.out.println("Fish is swimming.");
    }
}
