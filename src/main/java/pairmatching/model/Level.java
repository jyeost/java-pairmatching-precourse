package pairmatching.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5", Collections.emptyList());

    private final String name;
    private final List<String> missions;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static String printLevel() {
        StringBuilder sb = new StringBuilder();
        for (Level level : Level.values()) {
            sb.append(System.lineSeparator() + "  - " + level.name + ": ")
                    .append(String.join(" | ", level.missions));

        }
        return sb.toString();
    }

    public static boolean isLevelMission(String inputLevel, String inputMission) {
        for (Level level : Level.values()) {
            if (level.name.equals(inputLevel) && level.missions.contains(inputMission)) return true;
        }
        return false;
    }

    public static boolean isLevel3And5(String inputLevel) {
        return LEVEL3.name.equals(inputLevel) || LEVEL5.name.equals(inputLevel);
    }

    public static Level getLevel(String inputLevel) {
        for (Level level : Level.values()) {
            if (level.name.equals(inputLevel)) return level;
        }
        return null;
    }
}
