package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crew {
    private static final String ERROR_MSG = "[ERROR] 존재하는 과정,레벨,미션을 쉼표로 구분하여 모두 정확하게 입력해주세요.";
    private static final String LEVEL_ERROR_MSG = "[ERROR] 해당과정은 미션이 존재하지 않으므로 페어매칭을 진행할 수 없습니다.";
    private Course course;
    private Level level;
    private String mission;
    private List<Pair> pairs;
    private List<String> crewNames;

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
        this.crewNames = new ArrayList<>();
        this.pairs = new ArrayList<>();
    }

    public void matchPair() {
        readFile();
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        for (int i = 0; i < shuffledCrew.size(); i += 2) {
            if (i == shuffledCrew.size() - 3) {
                pairs.add(new Pair(shuffledCrew.subList(i, i + 3)));
                break;
            }
            pairs.add(new Pair(shuffledCrew.subList(i, i + 2)));
        }
    }

    private void readFile() {
        String path = "C:\\Users\\sist\\java-pairmatching-precourse\\src\\main\\resources\\";
        if (course == Course.BACKEND) path += "backend-crew.md";
        if (course == Course.FRONTEND) path += "frontend-crew.md";
        try {
            readPath(path);
        } catch (IOException e) {
            System.out.println("파일 읽기에 실패했습니다.");
        }
    }

    private void readPath(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            crewNames.add(line);
        }
        br.close();
    }

    public boolean isEqualMission(Crew crew) {
        return this.course.equals(crew.course) && this.level.equals(crew.level) && this.mission.equals(crew.mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair pair : pairs) {
            sb.append(pair.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
