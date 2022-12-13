package pairmatching.controller;

import pairmatching.model.MatchingFunction;
import pairmatching.view.Input;
import pairmatching.view.Output;

public class PairMatchingController {
    private final Input input;
    private final Output output;

    public PairMatchingController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void startMatching() {
        MatchingFunction matchingFunction;
        do {
            matchingFunction = input.getMatchingFunction();
            if (matchingFunction == MatchingFunction.MATCHING) doPairMatching();
            // if (matchingFunction == MatchingFunction.VIEW) doPairMatching();
            // if (matchingFunction == MatchingFunction.INIT_MATCHING) doPairMatching();
        } while (matchingFunction != MatchingFunction.QUIT);
    }

    private void doPairMatching() {
        output.printCourseLevelMission();
        input.getCourseLevelMission();
    }

}
