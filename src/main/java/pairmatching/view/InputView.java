package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Crew;
import pairmatching.model.MatchingFunction;

public class InputView implements Input {
    @Override
    public MatchingFunction getMatchingFunction() {
        try {
            System.out.println("기능을 선택하세요.");
            System.out.print(MatchingFunction.printKeysAndValues());
            return MatchingFunction.checkInput(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMatchingFunction();
        }
    }

    @Override
    public Crew getCourseLevelMission() {
        try {
            System.out.println("과정, 레벨, 미션을 선택하세요." + System.lineSeparator() + "ex) 백엔드, 레벨1, 자동차경주");
            return new Crew(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCourseLevelMission();
        }
    }
}
