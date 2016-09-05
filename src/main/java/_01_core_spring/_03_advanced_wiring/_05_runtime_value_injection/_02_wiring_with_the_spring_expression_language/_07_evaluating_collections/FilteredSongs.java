package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._07_evaluating_collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilteredSongs {

    private List<Song> songsOfU2;
    private List<Song> songsOfBobDylan;

    @Autowired
    public FilteredSongs(@Value("#{compactDisc.songs.?[author == 'U2']}") List<Song> songsOfU2, @Value("#{compactDisc.songs.?[author == 'Bob Dylan']}") List<Song> songsOfBobDylan) {
        this.songsOfU2 = songsOfU2;
        this.songsOfBobDylan = songsOfBobDylan;
    }

    public List<Song> getSongsOfU2() {
        return songsOfU2;
    }

    public List<Song> getSongsOfBobDylan() {
        return songsOfBobDylan;
    }
}
