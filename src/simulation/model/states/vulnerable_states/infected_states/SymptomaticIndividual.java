package simulation.model.states.vulnerable_states.infected_states;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import simulation.init.INIT_STATE;
import simulation.utils.Draw;
import simulation.init.SIMULATION_CONSTANTS;
import simulation.model.Individual;
import simulation.model.IndividualState;
import simulation.model.states.InvulnerableIndividual;
import simulation.model.states.vulnerable_states.InfectedIndividual;
import simulation.model.vectors.Coordinates;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class SymptomaticIndividual implements IndividualState {
    private final int probabilityOfInfecting = 100;
    private final Individual individual;
    private int infectedForSeconds;
    private Coordinates coordinates;
    private LinkedList<List<Individual>> encountersHistory;


    public List<List<Individual>> getEncountersHistory() {
        return this.encountersHistory;
    }

    public SymptomaticIndividual(Individual individual) {
        this.individual = individual;
        this.infectedForSeconds = Draw.drawDurationOfInfection(20, 30);
        this.encountersHistory = new LinkedList<>();
        this.coordinates = new Coordinates(0.0, 0.0);

    }

    @Override
    public void infect(Individual victim) {
        if (Draw.drawInfection(probabilityOfInfecting)) {
            victim.processInteraction(new InfectedIndividual(victim));
        }
    }

    @Override
    public void processInteraction(IndividualState proposedState) {
        ;
    }

    @Override
    public void initiateInteraction() {
        var individualsToPotentiallyInfect = getIndividualsToPotentiallyInfect();
        if (individualsToPotentiallyInfect.isEmpty()) {
            return;
        }
        getIndividualsToPotentiallyInfect().stream()
                .forEach(this::infect);
    }
    public void heal() {
        this.getIndividual().setState(new InvulnerableIndividual(this.getIndividual()));
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

    public void printState() {
        System.out.println(this);
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
    public void processNextCycle() {
        move();
    }

    private List<Individual> getIndividualsToPotentiallyInfect() {
        if (this.encountersHistory.size() < 3) {
            return List.of();
        }
        var flattenedOccurrenceSet = this.encountersHistory.stream()
                .flatMap(ind -> ind.stream())
                .collect(Collectors.toSet());
        var lastIndex = this.encountersHistory.size() - 1;
        return flattenedOccurrenceSet.stream()
                .filter(ind -> this.encountersHistory.get(lastIndex).contains(ind)
                        && this.encountersHistory.get(lastIndex - 1).contains(ind)
                        && this.encountersHistory.get(lastIndex - 2).contains(ind))
                .collect(Collectors.toList());
    }
    public void processASimulationSecond(List<Individual> nearbyIndividuals) {
        if (infectedForSeconds == 0) {
            heal();
        }
        infectedForSeconds--;
        updateEncountersHistory(nearbyIndividuals);
        this.initiateInteraction();
    }
    public void updateEncountersHistory(List<Individual> nearbyIndividuals) {
        this.encountersHistory.add(nearbyIndividuals);
        if (this.encountersHistory.size() == 4) {
            this.encountersHistory.pop();
        }
    }
    @Override
    public IndividualState clone() {
        var ind = new Individual(INIT_STATE.INFECTED);
        var state = new SymptomlessIndividual(ind);
        state.setCoordinates(new Coordinates(this.coordinates.getX(), this.coordinates.getY()));
        state.setEncountersHistory(copyEncountersHistory());
        state.setInfectedForSeconds(this.getInfectedForSeconds());
        ind.setState(state);

        return state;
    }
    public LinkedList<List<Individual>> copyEncountersHistory() {
        var listOfLists = new LinkedList<List<Individual>>();

        this.encountersHistory.stream()
                .forEach(li -> {
                    listOfLists.add(li.stream()
                            .map(ind -> ind.shallowClone())
                            .collect(Collectors.toList()));
                });
        return listOfLists;
    }
    public IndividualState shallowClone() {
        var ind = new Individual(INIT_STATE.INFECTED);
        var state = new SymptomlessIndividual(ind);
        state.setCoordinates(new Coordinates(this.coordinates.getX(), this.coordinates.getY()));
        state.setEncountersHistory(new LinkedList<List<Individual>>());
        state.setInfectedForSeconds(this.getInfectedForSeconds());
        ind.setState(state);

        return state;
    }
}
