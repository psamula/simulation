package simulation.domain.states.sub_states;

import simulation.Draw;
import simulation.domain.Individual;
import simulation.domain.IndividualState;
import simulation.domain.states.sub_states.infected_states.SymptomaticIndividual;
import simulation.domain.states.sub_states.infected_states.SymptomlessIndividual;

import java.util.Collection;

public class HealthyIndividual implements IndividualState {
    private int probabilityOfInfecting = 0;
    boolean immune =
    @Override
    public void infect(Individual victim) {
        if (!Draw.draw(this.probabilityOfInfecting)) {
            return;
        }
        if (Draw.draw(50)) {
            victim.processNewState(new SymptomlessIndividual());
            return;
        }
        victim.processNewState(new SymptomaticIndividual());
    }

    @Override
    public int getProbabilityOfInfecting() {
        return 0;
    }

    @Override
    public void interact(Collection<Individual> nearbyIndividuals) {
        nearbyIndividuals.stream().forEach(otherInd -> );
    }
}
