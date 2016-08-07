package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies.listing_01_08_starting_a_spring_context.with_java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightAppConfig {

    @Bean
    public Knight knight(){
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest(){
        return new SlayDragonQuest(System.out);
    }

}
