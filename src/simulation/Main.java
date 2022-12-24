package simulation;

import simulation.domain.Individual;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.fillIndividuals();
        simulation.globalInteract();
        var x = simulation.getIndividuals();
        x.stream()
                .forEach(Individual::printState);
    }
}