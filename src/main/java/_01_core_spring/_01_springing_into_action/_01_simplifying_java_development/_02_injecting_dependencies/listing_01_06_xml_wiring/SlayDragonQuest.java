package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies.listing_01_06_xml_wiring;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

    private PrintStream printStream;

    public SlayDragonQuest(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void embark() {
        printStream.println("embarking on quest to slay the dragon");
    }
}
