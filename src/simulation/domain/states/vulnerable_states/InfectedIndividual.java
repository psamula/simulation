package simulation.domain.states.vulnerable_states;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import simulation.Draw;
import simulation.domain.Individual;
import simulation.domain.IndividualState;
import simulation.domain.states.VulnerableIndividual;
import simulation.domain.states.vulnerable_states.infected_states.SymptomaticIndividual;
import simulation.domain.states.vulnerable_states.infected_states.SymptomlessIndividual;

import java.util.Collection;
@Getter
@Setter
@ToString
public class InfectedIndividual implements IndividualState {
    boolean immune = true;
    public IndividualState substate;
//    public Individual getIndividual() {
//        //return super.getIndividual();
//    }

    public InfectedIndividual(Individual individual) {
        //super(individual);
//        this.individual = individual;
        if (Draw.draw(50)) {
            this.substate = new SymptomaticIndividual(individual);
        } else {
            this.substate = new SymptomlessIndividual(individual);
        }
    }
    @Override
    public void infect(Individual individual) {
        this.substate.infect(individual);
    }

    @Override
    public void processInteraction(IndividualState proposedState) {
        this.substate.processInteraction(proposedState);
    }

    @Override
    public void initiateInteraction(Collection<Individual> nearbyIndividuals) {
        this.substate.initiateInteraction(nearbyIndividuals);
    }

    @Override
    public void heal() {
        this.substate.heal();
    }
    public void printState() {
        this.substate.printState();
    }
}
