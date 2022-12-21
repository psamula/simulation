package simulation.domain.states;

import simulation.domain.Individual;
import simulation.domain.IndividualState;

import java.util.Collection;

public class InvulnerableIndividual implements IndividualState {
    boolean immune = true;

    @Override
    public void infect(Individual individual) {

    }

    @Override
    public IndividualState processInteraction(IndividualState proposedState) {

    }

    @Override
    public void initiateInteraction(Collection<Individual> nearbyIndividuals) {

    }
}
