package simulation.memento;

import lombok.Getter;
import lombok.Setter;
import simulation.Simulation;
import simulation.model.Individual;

import java.util.List;

@Getter
@Setter
public class Memento {
    private List<Individual> individuals;
    private int t;

    public Memento(List<Individual> individuals, int second) {
        this.individuals = individuals;
        this.t = second;
    }
}
