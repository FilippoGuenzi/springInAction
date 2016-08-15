package _01_core_spring._02_wiring_beans._05_importing_and_mixing_configurations._00_import_java_config_into_java_config._01_flat_tree_of_dependencies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class PlayerSpringConfig {
    @Bean
    public CDPlayer myPlayer(CompactDisc cd){
        return new CDPlayer(cd);
    }
}
