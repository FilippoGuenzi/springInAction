package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._03_initializing_a_bean_with_constructor_injection._03_WIRING_COLLECTIONS;

import java.util.List;

public class Discography {
    private String artist;
    private List<CompactDisc> cds;

    public Discography(String artist, List<CompactDisc> cds) {
        this.artist = artist;
        this.cds = cds;
    }

    public void play() {
        if (cds != null) {
            for(CompactDisc cd : cds){
                cd.play();
            }
        }
    }
}
