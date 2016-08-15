package _01_core_spring._02_wiring_beans._05_importing_and_mixing_configurations._01_import_xml_config_into_java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("listing_in_01_02_05_01/CDConfig.xml")
public class PlayerSpringConfig {
    @Bean
    public CDPlayer myPlayer(CompactDisc cd){
        return new CDPlayer(cd);
    }
}
