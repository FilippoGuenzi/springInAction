package _01_core_spring._01_springing_into_action._01_simplifying_java_development._03_applying_aspects.listing_01_10_logging_with_aop;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

    private PrintStream printStream;

    public SlayDragonQuest(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void embark() {
        printStream.println("embarking on a quest to slay a Dragon");
    }
}
