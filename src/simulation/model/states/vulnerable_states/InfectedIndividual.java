package simulation.model.states.vulnerable_states;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import simulation.utils.Draw;
import simulation.model.Individual;
import simulation.model.IndividualState;
import simulation.model.states.vulnerable_states.infected_states.SymptomaticIndividual;
import simulation.model.states.vulnerable_states.infected_states.SymptomlessIndividual;
import simulation.model.vectors.Coordinates;

import java.util.List;

@Getter
@Setter
@ToString
public class InfectedIndividual implements IndividualState {
    boolean immune = true;
    public IndividualState substate;
    private Coordinates coordinates;
    public InfectedIndividual(Individual individual) {
        if (Draw.drawInfection(50)) {
            this.substate = new SymptomaticIndividual(individual);
        } else {
            this.substate = new SymptomlessIndividual(individual);
        }
        this.coordinates = new Coordinates(0.0, 0.0);

    }
    @Override
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public Individual getIndividual() {
        return this.substate.getIndividual();
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
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

    @Override
    public void heal() {
        this.substate.heal();
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
    public IndividualState clone() {
        return this.substate.clone();
    }
}
