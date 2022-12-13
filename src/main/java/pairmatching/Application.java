package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.InputView;
import pairmatching.view.OutputVIew;

public class Application {
    public static void main(String[] args) {
        new PairMatchingController(new InputView(), new OutputVIew()).startMatching();
    }
}
