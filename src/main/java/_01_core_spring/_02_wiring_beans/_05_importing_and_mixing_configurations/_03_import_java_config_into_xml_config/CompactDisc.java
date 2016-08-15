package _01_core_spring._02_wiring_beans._05_importing_and_mixing_configurations._03_import_java_config_into_xml_config;

import java.util.List;

public class CompactDisc {
    private String author;
    private String title;
    private List<String> tracks;

    public CompactDisc(String author, String title, List<String> tracks) {
        this.author = author;
        this.title = title;
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + author);
        if (tracks != null && tracks.size() > 0) {
            for (String track : tracks) {
                System.out.println("- track : " + track);
            }
        }
    }
}
