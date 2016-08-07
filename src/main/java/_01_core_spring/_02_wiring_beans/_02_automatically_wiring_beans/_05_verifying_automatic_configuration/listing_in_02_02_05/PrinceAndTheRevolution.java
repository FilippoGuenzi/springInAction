package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._05_verifying_automatic_configuration.listing_in_02_02_05;

import _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._01_creating_discoverable_beans.listing_02_01_02_03_java_component_scanning.*;
import org.springframework.stereotype.Component;

@Component
public class PrinceAndTheRevolution implements CompactDisc {
    private String title = "Prince and the Revolution";
    private String author = "Prince";
    private String log;

    public void setLog(String log) {
        this.log = log;
    }

    public String getLog() {
        return log;
    }

    public void play() {
        setLog("CD " + title + " by " + author + " is being played");
        System.out.println(log);
    }
}
