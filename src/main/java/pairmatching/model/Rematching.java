package pairmatching.model;

public enum Rematching {
    YES("네"), NO("아니오");

    private final String value;

    Rematching(String value) {
        this.value = value;
    }

    public static String print() {
        String print = "";
        for (Rematching rematching : Rematching.values()) {
            print += rematching.value + " | ";
        }
        return print.substring(0, print.length() - 3);
    }

    public static Rematching checkInput(String userInput) {
        for (Rematching rematching : Rematching.values()) {
            if (rematching.value.equals(userInput)) return rematching;
        }
        throw new IllegalArgumentException("리매칭 여부는 [ " + print() + " ]로만 입력해주세요");
    }
}
