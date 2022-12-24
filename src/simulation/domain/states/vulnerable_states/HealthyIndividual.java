package simulation.domain.states.vulnerable_states;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import simulation.domain.Individual;
import simulation.domain.IndividualState;

import java.util.Collection;
@Getter
@Setter
@ToString
public class HealthyIndividual implements IndividualState {
    private int probabilityOfInfecting = 0;
    private Individual individual;

    public HealthyIndividual(Individual individual) {
        this.individual = individual;
    }

    @Override
    public void infect(Individual victim) {
        ;
    }

    @Override
    public void processInteraction(IndividualState proposedState) {
        this.individual.setState(proposedState);
    }

    @Override
    public void initiateInteraction(Collection<Individual> nearbyIndividuals) {
        ;
    }
    public void heal() {
        ;
    }
    public void printState() {
        System.out.println(this);
    }
}
