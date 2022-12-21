package simulation.domain;

import java.util.Collection;

public interface IndividualState {
    void infect(Individual individual);
    IndividualState processInteraction(IndividualState proposedState);
    void initiateInteraction(Collection<Individual> nearbyIndividuals);
}
