package simulation.domain;

import simulation.domain.states.VulnerableIndividual;

import java.util.Collection;

public class Individual {


    private double x;
    private double y;
    private IndividualState state;


    public Individual() {
        this.state = new VulnerableIndividual(this);
    }

    public IndividualState getState() {
        return state;
    }

    public void setState(IndividualState state) {
        this.state = state;
    }

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

    public void initiateInteraction(Collection<Individual> nearbyIndividuals) {
        this.state.initiateInteraction(nearbyIndividuals);
    }

    public void processInteraction(IndividualState proposedState) {
        this.state.processInteraction(proposedState);
    }
}
