package simulation.model.vectors;

public interface IVector2D{
    double abs();
    double cdot(IVector2D vector);
    Coordinates getCoordinates();
}
