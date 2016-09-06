package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._07_evaluating_collections;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("listing_in_01_03_05_02_07/springConf.xml");
        FilteredSongs filteredSongs = context.getBean(FilteredSongs.class);
        System.out.println("Songs of U2");
        for(Song s : filteredSongs.getSongsOfU2()) {
            System.out.println(s.getAuthor() + " " + s.getTitle());
        }
        System.out.print("\n");
        System.out.println("Songs of Bob Dylan");
        for(Song s : filteredSongs.getSongsOfBobDylan()) {
            System.out.println(s.getAuthor() + " " + s.getTitle());
        }
        System.out.println("");
        System.out.println(filteredSongs.getFirstSongOfU2().getTitle());
        System.out.println("");
        System.out.println(filteredSongs.getFirstSongOfBobDylan().getTitle());
        System.out.println("");
        System.out.println(filteredSongs.getLastSongOfU2().getTitle());
        System.out.println("");
        System.out.println(filteredSongs.getLastSongOfBobDylan().getTitle());
        System.out.println("");
        for (String s : filteredSongs.getTitlesOfU2()){
            System.out.println(s);
        }
        System.out.println("");
        for (String s : filteredSongs.getTitlesOfBobDylan()){
            System.out.println(s);
        }
        System.out.println("");
        System.out.println(filteredSongs.getRandomSongOfCD().getTitle());
        context.close();
    }
}
