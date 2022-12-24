package simulation.domain.states.vulnerable_states.infected_states;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import simulation.domain.Individual;
import simulation.domain.IndividualState;
import simulation.domain.states.vulnerable_states.HealthyIndividual;
import simulation.domain.states.vulnerable_states.InfectedIndividual;

import java.util.Collection;
@Getter
@Setter
@ToString
public class SymptomaticIndividual implements IndividualState {
    private Individual individual;
    private int probabilityOfInfecting = 100;

    public SymptomaticIndividual(Individual individual) {
        this.individual = individual;
    }

    @Override
    public void infect(Individual victim) {
        victim.processInteraction(new InfectedIndividual(victim));
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
            this.individual.setState(new HealthyIndividual(this.individual));
        }
    }
    public void printState() {
        System.out.println(this);
    }
}
