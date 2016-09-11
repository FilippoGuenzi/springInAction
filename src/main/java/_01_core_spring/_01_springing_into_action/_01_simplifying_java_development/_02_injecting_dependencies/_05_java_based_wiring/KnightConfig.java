package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies._05_java_based_wiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfig {
    @Bean
    public Knight knight(){return new BraveKnight(quest());}
    @Bean
    public Quest quest(){return new SlayDragonQuest(System.out);}
}
