package simulation;

import simulation.init.INIT_SCENARIO;
import simulation.memento.Caretaker;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Simulation simulation = new Simulation();
        simulation.simulate(INIT_SCENARIO.SOME_INVULNERABLE);
        Caretaker caretaker = new Caretaker();
    }
}