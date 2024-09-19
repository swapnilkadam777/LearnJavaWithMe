package SingleResponsibilityPrinciple;

public class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public void fly() {
        System.out.println(name + " is flying.");
    }

    public void layEggs() {
        System.out.println(name + " is laying eggs.");
    }

    public void sing() {
        System.out.println(name + " is singing.");
    }

    public void displayInfo() {
        System.out.println("Bird Name: " + name);
    }
}
