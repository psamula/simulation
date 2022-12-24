package simulation.domain;

import java.util.Collection;

public interface IndividualState {
    void infect(Individual individual);
    void processInteraction(IndividualState proposedState);
    void initiateInteraction(Collection<Individual> nearbyIndividuals);
    void heal();

    void printState();

//    void setSubstate(IndividualState individualState;
}
