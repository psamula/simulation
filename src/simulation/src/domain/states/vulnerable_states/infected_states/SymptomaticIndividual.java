package simulation.src.domain.states.vulnerable_states.infected_states;

import simulation.src.domain.Individual;
import simulation.src.domain.IndividualState;
import simulation.src.domain.states.vulnerable_states.InfectedIndividual;

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
