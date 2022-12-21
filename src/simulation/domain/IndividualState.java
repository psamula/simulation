package domain;

import java.util.Collection;

public interface IndividualState {
    void infect(Individual individual);
    int getProbabilityOfInfecting();
    void interact(Collection<Individual> nearbyIndividuals);
}
