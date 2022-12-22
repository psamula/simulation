package simulation.src.domain.states.vulnerable_states.infected_states;

import simulation.src.Draw;
import simulation.src.domain.Individual;
import simulation.src.domain.IndividualState;
import simulation.src.domain.states.vulnerable_states.InfectedIndividual;

import java.util.Collection;

public class SymptomlessIndividual extends InfectedIndividual {
    private int probabilityOfInfecting = 50;

    public SymptomlessIndividual(Individual individual) {
        super(individual);
    }

    @Override
    public void infect(Individual victim) {
        if (!Draw.draw(this.probabilityOfInfecting)) {
            return;
        }
        if (Draw.draw(50)) {
            victim.processInteraction(new SymptomlessIndividual());
            return;
        }
        victim.processInteraction(new SymptomaticIndividual());
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