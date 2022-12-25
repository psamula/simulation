package simulation.model.states;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import simulation.model.Individual;
import simulation.model.IndividualState;
import simulation.model.states.vulnerable_states.HealthyIndividual;
import simulation.model.vectors.Coordinates;

import java.util.List;

@Getter
@Setter
@ToString
public class VulnerableIndividual implements IndividualState {
    boolean immune = false;
    private Individual individual;
    private IndividualState substate = new HealthyIndividual(this.individual); // initially

    public VulnerableIndividual(Individual individual) {
        this.individual = individual;
    }

    public void setSubstate(IndividualState substate) {
        this.substate = substate;
    }

    @Override
    public void heal() {
        this.substate.heal();
    }

    @Override
    public void infect(Individual individual) {
       this.substate.infect(individual);
    }

    @Override
    public void processInteraction(IndividualState proposedState) {
        this.substate.processInteraction(proposedState);
    }

    @Override
    public void initiateInteraction() {
        this.substate.initiateInteraction();
    }
    public void printState() {
        this.substate.printState();
    }

    @Override
    public void processNextCycle() {
        this.substate.processNextCycle();
    }

    @Override
    public void processASimulationSecond(List<Individual> nearbyIndividuals) {
        this.substate.processASimulationSecond(nearbyIndividuals);
    }

    @Override
    public void move() {
        this.substate.move();
    }

    @Override
    public Coordinates getCoordinates() {
        return this.substate.getCoordinates();
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.substate.setCoordinates(coordinates);

    }
}
