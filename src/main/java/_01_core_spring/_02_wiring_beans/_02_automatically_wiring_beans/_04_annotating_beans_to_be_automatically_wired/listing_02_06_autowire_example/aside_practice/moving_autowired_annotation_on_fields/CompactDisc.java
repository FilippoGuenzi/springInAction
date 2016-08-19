package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._04_annotating_beans_to_be_automatically_wired.listing_02_06_autowire_example.aside_practice.moving_autowired_annotation_on_fields;

import org.springframework.stereotype.Component;

@Component
public class CompactDisc implements Disc {
    private String author;
    private String title;

    public CompactDisc() {
        this.author = "David Bowie";
        this.title = "Ziggy Stardust";
    }

    public void play() {
        System.out.println("playing " + title + " by " + author);
    }
}
