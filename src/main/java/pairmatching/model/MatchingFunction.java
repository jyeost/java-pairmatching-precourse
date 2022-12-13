package pairmatching.model;

public enum MatchingFunction {
    MATCHING("1", "페어 매칭"),
    VIEW("2", "페어 조회"),
    INIT_MATCHING("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String key;
    private final String value;

    MatchingFunction(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String printKeysAndValues() {
        StringBuilder sb = new StringBuilder();
        for (MatchingFunction matchingFunction : MatchingFunction.values()) {
            sb.append(matchingFunction.key)
                    .append(". ")
                    .append(matchingFunction.value)
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static MatchingFunction checkInput(String userInput) {
        StringBuilder sb = new StringBuilder();
        for (MatchingFunction matchingFunction : MatchingFunction.values()) {
            if (matchingFunction.key.equals(userInput)) return matchingFunction;
            sb.append(matchingFunction.key).append(" ");
        }
        throw new IllegalArgumentException("기능은 [ " + sb + "] 으로만 입력 가능합니다.");
    }
}
