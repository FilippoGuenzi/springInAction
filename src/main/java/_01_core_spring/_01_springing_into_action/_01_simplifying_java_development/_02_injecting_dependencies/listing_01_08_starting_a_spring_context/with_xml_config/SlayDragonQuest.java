package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies.listing_01_08_starting_a_spring_context.with_xml_config;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

    private PrintStream printStream;

    public SlayDragonQuest(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void embark() {
        printStream.println("embark on a quest to slay a Dragon");
    }
}
