package simulation.domain.states.vulnerable_states.infected_states;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import simulation.Draw;
import simulation.domain.Individual;
import simulation.domain.IndividualState;
import simulation.domain.states.vulnerable_states.HealthyIndividual;
import simulation.domain.states.vulnerable_states.InfectedIndividual;

import java.util.Collection;
@Getter
@Setter
@ToString
public class SymptomlessIndividual implements IndividualState {
    private final int probabilityOfInfecting = 50;
    private Individual individual;
    public SymptomlessIndividual(Individual individual) {
        this.individual = individual;
    }

    @Override
    public void infect(Individual victim) {
        if (Draw.draw(probabilityOfInfecting)) {
            victim.processInteraction(new InfectedIndividual(victim));
        }
    }

    @Override
    public void processInteraction(IndividualState proposedState) {
        ;
    }

    @Override
    public void initiateInteraction(Collection<Individual> nearbyIndividuals) {
        nearbyIndividuals.stream()
                .forEach(otherInd -> infect(otherInd));
    }
    public void heal() {
        if (false/*todo*/) {
            this.getIndividual().setState(new HealthyIndividual(this.getIndividual()));
        }
    }
    public void printState() {
        System.out.println(this);
    }
}
