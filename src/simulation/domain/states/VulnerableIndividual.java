package simulation.domain.states;

import simulation.domain.Individual;
import simulation.domain.IndividualState;

import java.util.Collection;

public class VulnerableIndividual implements IndividualState {
    boolean immune = false;
    private VulnerableIndividual substate; //object which inherits from this class
    private Individual individual;

    public VulnerableIndividual(Individual individual) {
        this.individual = individual;
    }

    @Override
    public void infect(Individual individual) {
        substate.infect(individual);
    }

    @Override
    public IndividualState processInteraction(IndividualState proposedState) {
    }

    @Override
    public void initiateInteraction(Collection<Individual> nearbyIndividuals) {

    }
}
