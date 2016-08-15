package _01_core_spring._02_wiring_beans._05_importing_and_mixing_configurations._00_import_java_config_into_java_config._00_linked_dependencies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration()
@Import(CDSpringConfig.class)
public class PlayerSpringConfig {
    @Bean
    public CDPlayer myPlayer(CompactDisc cd){
        return new CDPlayer(cd);
    }
}
