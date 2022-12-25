package simulation;

import lombok.Getter;
import lombok.Setter;
import simulation.init.INIT_SCENARIO;
import simulation.init.INIT_STATE;
import simulation.init.SIMULATION_CONSTANTS;
import simulation.model.Individual;
import simulation.utils.Draw;
import simulation.utils.SimulationPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
@Getter
@Setter
public class Simulation {
    private static final int AMOUNT_OF_INDIVIDUALS = SIMULATION_CONSTANTS.AMOUNT_OF_INDIVIDUALS;
    public static final double RANGE = SIMULATION_CONSTANTS.RANGE;
    public static final double N = SIMULATION_CONSTANTS.N;
    public static final double M = SIMULATION_CONSTANTS.M;
    private List<Individual> individuals = new ArrayList<>();

    public void fillIndividuals(INIT_SCENARIO scenario) {
        spawnInfectedIndividuals(4);
        switch (scenario) {
            case ALL_VULNERABLE -> {
                for (int i = 0; i < AMOUNT_OF_INDIVIDUALS; i++) {
                    this.individuals.add(new Individual(INIT_STATE.VULNERABLE));
                }
            }
            case SOME_INVULNERABLE -> {
                var impostor = new Individual(INIT_STATE.INFECTED);
                var impostor2 = new Individual(INIT_STATE.INFECTED);
                var impostor3 = new Individual(INIT_STATE.INFECTED);
                var impostor4 = new Individual(INIT_STATE.INFECTED);
                for (int i = 0; i < AMOUNT_OF_INDIVIDUALS - 4; i++) {
                    this.individuals.add(new Individual(INIT_STATE.VULNERABLE));
                }

            }
        }
    }
    public void scanForOutsiders() {
        var outsiders = this.individuals
                .stream()
                .filter(ind -> ind.getCoordinates().getX() > M || ind.getCoordinates().getY() > N)
                .collect(Collectors.toList());

        if (!outsiders.isEmpty()) {
            outsiders.forEach(ind -> {
                this.individuals.remove(ind);
            });
        }
    }


    public List<Individual> getNearbyIndividuals(Individual individual) {
        return this.individuals.stream()
                .filter(ind -> ind != individual)
                .filter(otherInd -> isNearby(individual, otherInd))
                .collect(Collectors.toList());
    }
    public void spawn(Individual individual) {
        var drawnCoords = Draw.drawSpawnCoords(M, N);
        individual.setCoordinates(drawnCoords);
    }
    public void simulationInit(INIT_SCENARIO scenario) {
        this.fillIndividuals(scenario);
        this.individuals.forEach(this::spawn);
    }
    public void simulate(INIT_SCENARIO scenario) throws InterruptedException {
        simulationInit(scenario);

        for (int i = 0;; i++) {
            this.individuals.forEach(ind -> ind.processASimulationSecond(getNearbyIndividuals(ind)));
            SimulationPrinter.printSimulationState(this.individuals);
            for (int j = 0; j < 25; j++) {
                this.individuals.forEach(Individual::processNextCycle);
                scanForOutsiders();
            }
            if (Draw.drawSpawningOrNot(60)) {
                spawnInfectedIndividuals(1);
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
    public boolean isNearby(Individual individual, Individual otherIndividual) {
        var x1 = individual.getCoordinates().getX();
        var x2 = otherIndividual.getCoordinates().getX();
        var y1 = individual.getCoordinates().getY();
        var y2 = otherIndividual.getCoordinates().getY();

        return ((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)) < RANGE * RANGE;
    }
    public void spawnInfectedIndividuals(int amount) {
        for (int i = 0; i < amount; i++) {
            this.individuals.add(new Individual(INIT_STATE.INFECTED));
        }
    }
}
