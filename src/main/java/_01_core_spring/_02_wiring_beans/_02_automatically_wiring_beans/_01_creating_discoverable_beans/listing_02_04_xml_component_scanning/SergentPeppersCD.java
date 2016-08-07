package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._01_creating_discoverable_beans.listing_02_04_xml_component_scanning;

import org.springframework.stereotype.Component;

@Component
public class SergentPeppersCD implements CompactDisc {
    private String title = "Sergent Peppers Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("playing " + title + " by " + artist);
    }
}
