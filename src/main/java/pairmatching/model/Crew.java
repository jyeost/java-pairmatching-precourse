package pairmatching.model;

import java.util.List;

public class Crew {
    private static final String ERROR_MSG = "[ERROR] 존재하는 과정,레벨,미션을 쉼표로 구분하여 모두 정확하게 입력해주세요.";
    private static final String LEVEL_ERROR_MSG = "[ERROR] 해당과정은 미션이 존재하지 않으므로 페어매칭을 진행할 수 없습니다.";
    private Course course;
    private Level level;
    private String mission;
    private List<Pair> pairs;

    public Crew(String userInput) {
        validateNotNullHavingComma(userInput);
        validateInputSize(userInput);
        validateCourseLevelMission(userInput);
    }

    private void validateNotNullHavingComma(String userInput) {
        if (userInput == null || "".equals(userInput) || !userInput.contains(","))
            throw new IllegalArgumentException(ERROR_MSG);
    }

    private void validateInputSize(String userInput) {
        if (userInput.split(",").length != 3)
            throw new IllegalArgumentException(ERROR_MSG);
    }

    private void validateCourseLevelMission(String userInput) {
        String[] userInputs = userInput.split(",");
        if (Level.isLevel3And5(userInputs[1].trim()))
            throw new IllegalArgumentException(LEVEL_ERROR_MSG);
        if (!Course.isCourse(userInputs[0].trim()) || !Level.isLevelMission(userInputs[1].trim(), userInputs[2].trim()))
            throw new IllegalArgumentException(ERROR_MSG);
        setField(userInputs);
    }

    private void setField(String[] userInputs) {
        this.course = Course.getCourse(userInputs[0].trim());
        this.level = Level.getLevel(userInputs[1].trim());
        this.mission = userInputs[2].trim();
    }

}
