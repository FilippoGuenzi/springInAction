package _01_core_spring._02_wiring_beans._05_importing_and_mixing_configurations._03_import_java_config_into_xml_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class CDConfig {

    @Bean(name = "yoyo")
    public CompactDisc getCD() {
        return new CompactDisc("Dire Straits", "Brother in Arms", Arrays.asList("Money for nothing", "Brother in Arms"));
    }

}
