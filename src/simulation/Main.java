package simulation;

import simulation.init.INIT_SCENARIO;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Simulation simulation = new Simulation();
        simulation.simulate(INIT_SCENARIO.SOME_INVULNERABLE);
    }
}