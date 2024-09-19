package InterfaceSegrigationPrinciple.PoorCode;

public class Fish implements Animal {
    @Override
    public void eat() {
        System.out.println("Fish is eating.");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Fish can't fly.");
    }

    @Override
    public void swim() {
        System.out.println("Fish is swimming.");
    }
}

