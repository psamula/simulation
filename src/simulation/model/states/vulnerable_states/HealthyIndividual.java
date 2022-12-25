package simulation.model.states.vulnerable_states;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import simulation.utils.Draw;
import simulation.model.Individual;
import simulation.model.IndividualState;
import simulation.model.vectors.Coordinates;

import java.util.List;

@Getter
@Setter
@ToString
public class HealthyIndividual implements IndividualState {
    private int probabilityOfInfecting = 0;
    private Individual individual;
    Coordinates coordinates;
    public HealthyIndividual(Individual individual) {
        this.individual = individual;
        this.coordinates = new Coordinates(0.0, 0.0);

    }
    @Override
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    @Override
    public void setCoordinates (Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public void infect(Individual victim) {
        ;
    }

    @Override
    public void processInteraction(IndividualState proposedState) {
        this.individual.setState(proposedState);
        System.out.println("INFECTION OCCURRED");
    }

    @Override
    public void initiateInteraction() {
        ;
    }
    public void heal() {
        ;
    }

    @Override
    public void move() {
        var drawnVector = Draw.drawVector(0, 0.1);
        var currentX = coordinates.getX();
        var currentY = coordinates.getY();

        this.coordinates.setX(currentX + drawnVector.getCoordinates().getX());
        this.coordinates.setY(currentY + drawnVector.getCoordinates().getY());
    }

    public void printState() {
        System.out.println(this);
    }
    @Override
    public void processNextCycle() {
        move();
    }

    @Override
    public void processASimulationSecond(List<Individual> nearbyIndividuals) {
        ;
    }
}
