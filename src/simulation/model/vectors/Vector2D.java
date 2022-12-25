package simulation.model.vectors;

public class Vector2D implements IVector2D{
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double abs() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    @Override
    public double cdot(IVector2D vector) {
        double otherX = vector.getCoordinates().getX();
        double otherY = vector.getCoordinates().getY();

        return this.x * otherX + this.y * otherY;
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                ", length=" + abs() +
                '}';
    }

    @Override
    public Coordinates getCoordinates() {
        return new Coordinates(x, y);
    }
}