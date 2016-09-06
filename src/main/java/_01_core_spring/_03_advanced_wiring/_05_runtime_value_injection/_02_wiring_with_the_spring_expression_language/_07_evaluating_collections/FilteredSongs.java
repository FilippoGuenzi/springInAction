package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._07_evaluating_collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilteredSongs {

    private List<Song> songsOfU2;
    private List<Song> songsOfBobDylan;
    private Song firstSongOfU2;
    private Song firstSongOfBobDylan;
    private Song lastSongOfU2;
    private Song lastSongOfBobDylan;
    private List<String> titlesOfU2;
    private List<String> titlesOfBobDylan;
    private Song randomSongOfCD;

    @Autowired
    public FilteredSongs(
            @Value("#{compactDisc.songs.?[author == 'U2']}")
            List<Song> songsOfU2,
            @Value("#{compactDisc.songs.?[author == 'Bob Dylan']}")
            List<Song> songsOfBobDylan,
            @Value("#{compactDisc.songs.^[author == 'U2']}")
            Song firstSongOfU2,
            @Value("#{compactDisc.songs.^[author == 'Bob Dylan']}")
            Song firstSongOfBobDylan,
            @Value("#{compactDisc.songs.$[author == 'U2']}")
            Song lastSongOfU2,
            @Value("#{compactDisc.songs.$[author == 'Bob Dylan']}")
            Song lastSongOfBobDylan,
            @Value("#{compactDisc.songs.?[author == 'U2'].![title]}")
            List<String> titlesOfU2,
            @Value("#{compactDisc.songs.?[author == 'Bob Dylan'].![title]}")
            List<String> titlesOfBobDylan,
            @Value("#{compactDisc.songs[T(java.lang.Math).floor(T(java.lang.Math).random() * compactDisc.songs.size())]}")
            Song randomSongOfCD
    ) {
        this.songsOfU2 = songsOfU2;
        this.songsOfBobDylan = songsOfBobDylan;
        this.firstSongOfU2 = firstSongOfU2;
        this.firstSongOfBobDylan = firstSongOfBobDylan;
        this.lastSongOfU2 = lastSongOfU2;
        this.lastSongOfBobDylan = lastSongOfBobDylan;
        this.titlesOfU2 = titlesOfU2;
        this.titlesOfBobDylan = titlesOfBobDylan;
        this.randomSongOfCD = randomSongOfCD;
    }

    public List<Song> getSongsOfU2() {
        return songsOfU2;
    }

    public List<Song> getSongsOfBobDylan() {
        return songsOfBobDylan;
    }

    public Song getFirstSongOfU2() {
        return firstSongOfU2;
    }

    public Song getFirstSongOfBobDylan() {
        return firstSongOfBobDylan;
    }

    public Song getLastSongOfU2() {
        return lastSongOfU2;
    }

    public Song getLastSongOfBobDylan() {
        return lastSongOfBobDylan;
    }

    public List<String> getTitlesOfU2() {
        return titlesOfU2;
    }

    public List<String> getTitlesOfBobDylan() {
        return titlesOfBobDylan;
    }

    public Song getRandomSongOfCD() {
        return randomSongOfCD;
    }
}
