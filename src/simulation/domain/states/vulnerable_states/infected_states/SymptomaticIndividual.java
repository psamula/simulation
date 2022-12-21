package simulation.domain.states.vulnerable_states.infected_states;

import simulation.domain.Individual;
import simulation.domain.IndividualState;
import simulation.domain.states.vulnerable_states.InfectedIndividual;

import java.util.Collection;

public class SymptomaticIndividual extends InfectedIndividual {
    private int probabilityOfInfecting = 100;

    @Override
    public void infect(Individual individual) {
        super.infect(individual);
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
