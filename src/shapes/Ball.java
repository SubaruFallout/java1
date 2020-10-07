package shapes;

public class Ball extends Shape {
    double radius;

    public Ball(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return 4. / 3. * Math.PI * radius * radius * radius;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "radius=" + radius +
                "}";
    }
}
