package _01_core_spring._02_wiring_beans._05_importing_and_mixing_configurations._00_import_java_config_into_java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;

@Configuration
public class CDSpringConfig {
    @Bean
    public CompactDisc getCD(){
        return new CompactDisc("Mina", "Parole", new ArrayList<String>());
    }
}
