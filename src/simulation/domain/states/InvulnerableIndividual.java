package simulation.domain.states;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import simulation.domain.Individual;
import simulation.domain.IndividualState;

import java.util.Collection;
@Getter
@Setter
@ToString
public class InvulnerableIndividual implements IndividualState {
    private Individual individual;
    boolean immune = true;

    public InvulnerableIndividual(Individual individual) {
        this.individual = individual;
    }

    @Override
    public void infect(Individual individual) {
        ;
    }

    @Override
    public void processInteraction(IndividualState proposedState) {
        ;
    }

    @Override
    public void initiateInteraction(Collection<Individual> nearbyIndividuals) {
        ;
    }

    @Override
    public void heal() {
        ;
    }
    public void printState() {
        System.out.println(this);
    }
}
