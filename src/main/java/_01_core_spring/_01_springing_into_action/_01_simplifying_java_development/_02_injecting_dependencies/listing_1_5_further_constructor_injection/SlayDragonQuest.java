package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies.listing_1_5_further_constructor_injection;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay the dragon");
    }
}
