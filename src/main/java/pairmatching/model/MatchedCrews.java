package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class MatchedCrews {
    private final List<Crew> matchedCrews;

    public MatchedCrews() {
        this.matchedCrews = new ArrayList<>();
    }

    public boolean checkExist(Crew crew) {
        for (int i = 0; i < matchedCrews.size(); i++) {
            if (matchedCrews.get(i).isEqualMission(crew)) return true;
        }
        return false;
    }

    public void add(Crew crew) {
        System.out.println("matchedCrews 사이즈 : " + matchedCrews.size());
        this.matchedCrews.add(crew);
    }

    public void remove(Crew crew) {
        for (int i = 0; i < matchedCrews.size(); i++) {
            if (matchedCrews.get(i).isEqualMission(crew)) matchedCrews.remove(i);
        }
    }
}
