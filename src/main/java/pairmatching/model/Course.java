package pairmatching.model;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static String printCourse() {
        String courses = "";
        for (Course course : Course.values()) {
            courses += course.name + " | ";
        }
        courses = courses.substring(0, courses.length() - 3);
        return courses;
    }

    public static boolean isCourse(String inputCourse) {
        for (Course course : Course.values()) {
            if (course.name.equals(inputCourse)) return true;
        }
        return false;
    }

    public static Course getCourse(String inputCourse) {
        for (Course course : Course.values()) {
            if (course.name.equals(inputCourse)) return course;
        }
        return null;
    }
}
