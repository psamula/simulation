package simulation.domain;

import simulation.domain.states.InvulnerableIndividual;
import simulation.domain.states.VulnerableIndividual;
import simulation.domain.states.vulnerable_states.HealthyIndividual;
import simulation.domain.states.vulnerable_states.InfectedIndividual;

import java.util.Collection;

public class Individual {


    private double x;
    private double y;
    private IndividualState state;


    public Individual(String stype) {
        if (stype.equals("impostor")) {
            var myState = new VulnerableIndividual(this);
            myState.setSubstate(new InfectedIndividual(this));
            this.state = myState; //init state
        } else if (stype.equals("immune")) {
            var myState = new InvulnerableIndividual(this);
            this.setState(myState);
        }
        else {
            var myState = new VulnerableIndividual(this);
            myState.setSubstate(new HealthyIndividual(this));
            this.state = myState; //init state
        }
    }

    public Individual() {
        var myState = new VulnerableIndividual(this);
        myState.setSubstate(new HealthyIndividual(this));
        this.state = myState; //init state
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
    public void printState() {
        this.state.printState();
    }
}
