package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._07_evaluating_collections;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("listing_in_01_03_05_02_07/springConf.xml");
        FilteredSongs filteredSongs = context.getBean(FilteredSongs.class);
        for(Song s : filteredSongs.getSongsOfU2()) {
            System.out.println(s.getAuthor() + " " + s.getTitle());
        }
        context.close();
    }
}
