package simulation.model;

import lombok.Getter;
import lombok.Setter;
import simulation.init.INIT_STATE;
import simulation.model.states.InvulnerableIndividual;
import simulation.model.states.VulnerableIndividual;
import simulation.model.states.vulnerable_states.HealthyIndividual;
import simulation.model.states.vulnerable_states.InfectedIndividual;
import simulation.model.vectors.Coordinates;

import java.util.List;
@Getter
@Setter

public class Individual {

    private IndividualState state;


    public Individual(INIT_STATE scenario) {
        switch(scenario) {

            case INFECTED:
                var myState1 = new VulnerableIndividual(this);
                myState1.setSubstate(new InfectedIndividual(this));
                this.state = myState1; //init state
                break;

            case INVULNERABLE:
                var myState2 = new InvulnerableIndividual(this);
                this.setState(myState2);
                break;

            case VULNERABLE:
                var myState3 = new VulnerableIndividual(this);
                myState3.setSubstate(new HealthyIndividual(this));
                this.state = myState3; //init state
                break;
        }
    }

    public Individual() {
        this(INIT_STATE.VULNERABLE);
    }

    public IndividualState getState() {
        return state;
    }

    public void setState(IndividualState state) {
        this.state = state;
    }

    public Coordinates getCoordinates() {
        return this.state.getCoordinates();
    }
    public void setCoordinates(Coordinates coordinates) {
        this.state.setCoordinates(coordinates);
    }

    public void initiateInteraction(List<Individual> nearbyIndividuals) {
        this.state.initiateInteraction();
    }

    public void processInteraction(IndividualState proposedState) {
        this.state.processInteraction(proposedState);
    }
    public void printState() {
        this.state.printState();
    }
    public void move() {
        this.state.move();
    }
    public void processNextCycle() {
        this.state.processNextCycle();
    }
    public void processASimulationSecond(List<Individual> nearbyIndividuals) {
        this.state.processASimulationSecond(nearbyIndividuals);
    }
    public Individual clone() {
        var state = this.state.clone();
        return state.getIndividual();
    }
    public Individual shallowClone() {
        var state = this.state.shallowClone();
        return state.getIndividual();
    }
}
