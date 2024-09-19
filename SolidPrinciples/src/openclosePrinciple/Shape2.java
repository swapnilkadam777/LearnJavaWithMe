package openclosePrinciple;

public class Shape2 {
    public static final int CIRCLE = 1;
    public static final int SQUARE = 2;

    private int shapeType;

    public Shape2(int shapeType) {
        this.shapeType = shapeType;
    }

    public void draw() {
        if (shapeType == CIRCLE) {
            System.out.println("Drawing a circle.");
        } else if (shapeType == SQUARE) {
            System.out.println("Drawing a square.");
        }
    }
}