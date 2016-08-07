package _01_core_spring._01_springing_into_action._01_simplifying_java_development._03_applying_aspects.listing_01_09_logging_without_aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightQuestConfig {

    @Bean
    public Knight getKnight() {
        return new BraveKnight(this.getQuest(), this.getMinstrel());
    }

    @Bean
    public Quest getQuest() {
        return new SlayDragonQuest(System.out);
    }

    @Bean
    Minstrel getMinstrel() {
        return new Minstrel(System.out);
    }
}
