package pairmatching.controller;

import pairmatching.model.Crew;
import pairmatching.model.MatchedCrews;
import pairmatching.model.MatchingFunction;
import pairmatching.model.Rematching;
import pairmatching.view.Input;
import pairmatching.view.Output;

public class PairMatchingController {
    private final Input input;
    private final Output output;
    private MatchedCrews matchedCrews;

    public PairMatchingController(Input input, Output output) {
        this.matchedCrews = new MatchedCrews();
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
        Crew crew = input.getCourseLevelMission();
        if (matchedCrews.checkExist(crew)) rematching(crew);
        crew.matchPair();
        output.printMatchingResult(crew);
        matchedCrews.add(crew);


    }

    private void rematching(Crew crew) {
        Rematching rematching = input.getRematching();
        if (rematching == Rematching.NO) startMatching();
        matchedCrews.remove(crew);
    }

}
