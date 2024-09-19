package LiskovSubstitutionPrinciple.PoorCode;

public class main {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird ostrich = new Ostrich();

        sparrow.fly(); // Works fine
        ostrich.fly(); // Throws an exception
    }
}
