package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._03_initializing_a_bean_with_constructor_injection._03_WIRING_COLLECTIONS;

import java.util.List;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc(String artist, String title, List<String> tracks) {
        this.artist = artist;
        this.title = title;
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        System.out.println(tracks == null);
    }
}
