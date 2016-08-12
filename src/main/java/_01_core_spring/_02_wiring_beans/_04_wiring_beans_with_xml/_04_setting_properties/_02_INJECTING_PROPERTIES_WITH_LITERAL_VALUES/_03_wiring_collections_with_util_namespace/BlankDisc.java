package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._04_setting_properties._02_INJECTING_PROPERTIES_WITH_LITERAL_VALUES._03_wiring_collections_with_util_namespace;

import java.util.List;

public class BlankDisc {

    private String author;
    private String title;
    private List<String> tracks;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("playing " + title + " by " + author);
        if (tracks != null) {
            for (String track : tracks) {
                System.out.println("- track : " + track);
            }
        }
    }
}
