package _01_core_spring._01_springing_into_action._01_simplifying_java_development._03_applying_aspects._01_logging_without_aop;

import java.io.PrintStream;

public class Minstrel {
    private PrintStream printStream;

    public Minstrel(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void singBeforeQuest() {
        printStream.println("Minstrel : the knight is preparing for the quest");
    }

    public void singAfterQuest() {
        printStream.println("Minstrel : the knight embarked on the quest !");
    }
}
