package pairmatching.view;

import pairmatching.model.Crew;
import pairmatching.model.MatchingFunction;
import pairmatching.model.Rematching;

public interface Input {
    MatchingFunction getMatchingFunction();

    Crew getCourseLevelMission();

    Rematching getRematching();
}
