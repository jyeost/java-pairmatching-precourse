package pairmatching.model;

import java.util.List;

public class Pair {
    private final List<String> pairNames;

    public Pair(List<String> pairNames) {
        this.pairNames = pairNames;
    }

    @Override
    public String toString() {
        return String.join(" : ", pairNames);
    }
}
