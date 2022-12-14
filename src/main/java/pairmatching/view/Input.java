package pairmatching.view;

import pairmatching.model.Crew;
import pairmatching.model.MatchingFunction;

public interface Input {
    MatchingFunction getMatchingFunction();

    Crew getCourseLevelMission();
}
