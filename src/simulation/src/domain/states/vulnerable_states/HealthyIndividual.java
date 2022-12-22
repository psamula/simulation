package simulation.src.domain.states.vulnerable_states;

import simulation.src.Draw;
import simulation.src.domain.Individual;
import simulation.src.domain.IndividualState;
import simulation.src.domain.states.vulnerable_states.infected_states.SymptomaticIndividual;
import simulation.src.domain.states.vulnerable_states.infected_states.SymptomlessIndividual;

import java.util.Collection;

public class HealthyIndividual implements IndividualState {
    private int probabilityOfInfecting = 0;
    @Override
    public void infect(Individual victim) {
        if (!Draw.draw(this.probabilityOfInfecting)) {
            return;
        }
        if (Draw.draw(50)) {
            victim.processInteraction(new SymptomlessIndividual(victim));
            return;
        }
        victim.processInteraction(new SymptomaticIndividual(victim));
    }

    @Override
    public IndividualState processInteraction(IndividualState proposedState) {
        return
    }

    @Override
    public void initiateInteraction(Collection<Individual> nearbyIndividuals) {
        nearbyIndividuals.stream().forEach(otherInd -> );
    }
}
