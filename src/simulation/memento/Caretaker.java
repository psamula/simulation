package simulation.memento;

import lombok.Getter;
import lombok.Setter;
import simulation.model.Individual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
@Setter
public class Caretaker {
    private List<Memento> mementos = new ArrayList<>();

    public void add(Memento memento) {
        mementos.add(memento);
    }
    public Memento get(int t) {
        return mementos.get(t);
    }
}
