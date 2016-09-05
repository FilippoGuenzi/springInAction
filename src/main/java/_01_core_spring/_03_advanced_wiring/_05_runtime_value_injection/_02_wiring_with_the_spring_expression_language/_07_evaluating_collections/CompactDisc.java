package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._07_evaluating_collections;

import java.util.List;

public class CompactDisc {

    private List<Song> songs;

    public CompactDisc(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
