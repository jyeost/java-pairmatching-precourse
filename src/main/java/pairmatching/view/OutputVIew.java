package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.Level;

public class OutputVIew implements Output {
    @Override
    public void printCourseLevelMission() {
        System.out.println(System.lineSeparator() + "#############################################");
        System.out.println("과정: " + Course.printCourse());
        System.out.print("미션:" + Level.printLevel());
        System.out.println(System.lineSeparator() + "#############################################");
    }
}
