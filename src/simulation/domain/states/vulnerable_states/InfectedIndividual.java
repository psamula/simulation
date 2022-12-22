package simulation.domain.states.vulnerable_states;

import simulation.domain.Individual;
import simulation.domain.IndividualState;
import simulation.domain.states.VulnerableIndividual;

import java.util.Collection;

public class InfectedIndividual extends VulnerableIndividual {
    boolean immune = true;
    public InfectedIndividual substate;

    public InfectedIndividual(Individual individual) {
        super(individual);
    }

    @Override
    public void infect(Individual individual) {
        this.substate.infect(individual);
    }

    @Override
    public IndividualState processInteraction(IndividualState proposedState) {
        super.processInteraction(proposedState);
    }

    @Override
    public void initiateInteraction(Collection<Individual> nearbyIndividuals) {
        super.initiateInteraction(nearbyIndividuals);
    }
}
