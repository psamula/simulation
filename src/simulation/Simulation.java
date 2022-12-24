package simulation;

import lombok.Getter;
import lombok.Setter;
import simulation.domain.Coordinates;
import simulation.domain.Individual;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class Simulation {
    private static final int AMOUNT_OF_INDIVIDUALS = 16;
    private List<Individual> individuals = new ArrayList<>();
    public static final double RANGE = 3.0;
    public static final double N = 15.0;
    public static final double M = 15.0;

    public void fillIndividuals() {
        for (int i = 0; i < AMOUNT_OF_INDIVIDUALS; i++) {
            this.individuals.add(new Individual());
        }
        var immune = new Individual("immune");
        var immune2 = new Individual("immune");
        var impostor = new Individual("impostor");
        this.individuals.add(impostor);
        this.individuals.add(immune);
        this.individuals.add(immune2);

    }


    public Collection<Individual> getNearbyIndividuals(Individual individual) {
        return this.individuals.stream()
                .filter(ind -> ind != individual)
                .filter(otherInd -> isNearby(individual, otherInd))
                .collect(Collectors.toList());
    }
    public void globalInteract() {
        this.individuals.stream()
                .forEach(ind -> {
                    ind.initiateInteraction(getNearbyIndividuals(ind));
                });
    }
//    public Collection<Individual> getIndividualsInsideInfectablePerimeter() {
//        return this.individuals.stream()
//                .filter(ind -> IsInsideInfectedPerimeter(ind))
//    }
//    public Coordinates findInfectedPerimeter() {
//        this.individuals.stream().filter(ind -> ind.getPosition)
//    }
    public boolean isNearby(Individual individual, Individual otherIndividual) {
        var x1 = individual.getCoordinates().getX();
        var x2 = otherIndividual.getCoordinates().getX();
        var y1 = individual.getCoordinates().getY();
        var y2 = otherIndividual.getCoordinates().getY();

        return ((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)) < RANGE * RANGE;
    }
}
