package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies._05_java_based_wiring;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

    private PrintStream printStream;

    public SlayDragonQuest(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void embark() {
        printStream.println("let's embark on quest to say dragon");
    }
}
