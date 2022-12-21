package domain;

import java.util.Collection;

public class Individual {


    private double x;
    private double y;
    private IndividualState state;
    public Coordinates getCoordinates() {
        return new Coordinates(this.x, this.y);
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }

    public void interact(Collection<Individual> nearbyIndividuals) {
        this.state.interact(nearbyIndividuals);
    }
}
