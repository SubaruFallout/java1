package shapes;

public class Cube extends Shape {
    double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "side=" + side +
                "}";
    }
}
