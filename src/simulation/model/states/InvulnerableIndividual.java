package simulation.model.states;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import simulation.init.INIT_STATE;
import simulation.model.states.vulnerable_states.infected_states.SymptomlessIndividual;
import simulation.utils.Draw;
import simulation.init.SIMULATION_CONSTANTS;
import simulation.model.Individual;
import simulation.model.IndividualState;
import simulation.model.vectors.Coordinates;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
public class InvulnerableIndividual implements IndividualState {
    private Individual individual;
    boolean immune = true;
    private Coordinates coordinates;

    public InvulnerableIndividual(Individual individual) {
        this.individual = individual;
        this.coordinates = new Coordinates(0.0, 0.0);

    }
    @Override
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
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
    public void initiateInteraction() {
        ;
    }

    @Override
    public void processNextCycle() {
        move();
    }

    @Override
    public void heal() {
        ;
    }
    public void printState() {
        System.out.println(this);
    }
    @Override
    public void move() {
        var drawnVector = Draw.drawVector(0, 0.1);
        var currentX = coordinates.getX();
        var currentY = coordinates.getY();

        var newX = currentX + drawnVector.getCoordinates().getX();
        var newY = currentY + drawnVector.getCoordinates().getY();

        this.coordinates.setX(currentX + drawnVector.getCoordinates().getX());
        this.coordinates.setY(currentY + drawnVector.getCoordinates().getY());

        if (!(newX > SIMULATION_CONSTANTS.N || newY > SIMULATION_CONSTANTS.M)) {
            return;
        }

        if (!Draw.drawLeavingOrNot(50)) {
            var spawnCoords = Draw.drawSpawnCoords(SIMULATION_CONSTANTS.M, SIMULATION_CONSTANTS.N);
            this.coordinates.setX((spawnCoords.getX()));
            this.coordinates.setY((spawnCoords.getY()));
        }

    }
    @Override
    public IndividualState clone() {
        var ind = new Individual(INIT_STATE.INVULNERABLE);
        var state = new InvulnerableIndividual(ind);
        state.setCoordinates(new Coordinates(this.coordinates.getX(), this.coordinates.getY()));
        state.setIndividual(ind);
        ind.setState(state);
        return state;
    }

    @Override
    public void processASimulationSecond(List<Individual> nearbyIndividuals) {
        ;
    }
    public IndividualState shallowClone() {
        return this.clone();
    }
}
