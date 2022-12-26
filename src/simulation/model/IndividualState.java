package simulation.model;

import simulation.model.vectors.Coordinates;

import java.util.List;

public interface IndividualState {
    void infect(Individual individual);
    void processInteraction(IndividualState proposedState);
    void initiateInteraction();
    void processNextCycle();
    void processASimulationSecond(List<Individual> nearbyIndividuals);
    void heal();
    void printState();
    void move();
    Coordinates getCoordinates();
    Individual getIndividual();
    IndividualState clone();
    void setCoordinates(Coordinates coordinates);
//    void setSubstate(IndividualState individualState;
}
