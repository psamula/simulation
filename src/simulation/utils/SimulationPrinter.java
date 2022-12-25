package simulation.utils;

import simulation.Simulation;
import simulation.model.Individual;
import simulation.model.states.InvulnerableIndividual;
import simulation.model.states.vulnerable_states.HealthyIndividual;

import java.util.List;

public class SimulationPrinter {
    private final Simulation simulation;

    public SimulationPrinter(Simulation simulation) {
        this.simulation = simulation;
    }
    public static void printSimulationState(List<Individual> individuals) {
        individuals.forEach(ind -> ind.printState());
        System.out.println("Currently living: " + individuals.size());

        System.out.println("\n\n");
    }
}
