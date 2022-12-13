package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
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
    public void getCourseLevelMission() {
        System.out.println();
    }
}
