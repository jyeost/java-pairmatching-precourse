package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.Level;

public class OutputVIew implements Output {
    @Override
    public void printCourseLevelMission() {
        System.out.println(System.lineSeparator() + "#############################################");
        System.out.println("과정: " + Course.printCourse());
        System.out.print("미션:" + Level.printLevel());
        System.out.println(System.lineSeparator() + "#############################################");
    }

    @Override
    public void printMatchingResult(Crew crew) {
        System.out.println(System.lineSeparator() + "페어 매칭 결과입니다.");
        System.out.println(crew);
    }
}
