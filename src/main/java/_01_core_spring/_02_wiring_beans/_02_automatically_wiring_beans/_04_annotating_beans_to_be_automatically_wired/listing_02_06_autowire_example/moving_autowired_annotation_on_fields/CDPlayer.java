package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._04_annotating_beans_to_be_automatically_wired.listing_02_06_autowire_example.moving_autowired_annotation_on_fields;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {
    @Autowired
    private CompactDisc compactDisc;

    public void play() {
        compactDisc.play();
    }
}
