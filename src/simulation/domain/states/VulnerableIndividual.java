package simulation.domain.states;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import simulation.domain.Individual;
import simulation.domain.IndividualState;

import java.util.Collection;
@Getter
@Setter
@ToString
public class VulnerableIndividual implements IndividualState {
    boolean immune = false;
    private IndividualState substate; //object which inherits from this class
    private Individual individual;

    public VulnerableIndividual(Individual individual) {
        this.individual = individual;
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
    public void initiateInteraction(Collection<Individual> nearbyIndividuals) {
        this.substate.initiateInteraction(nearbyIndividuals);
    }
    public void printState() {
        this.substate.printState();
    }
}
