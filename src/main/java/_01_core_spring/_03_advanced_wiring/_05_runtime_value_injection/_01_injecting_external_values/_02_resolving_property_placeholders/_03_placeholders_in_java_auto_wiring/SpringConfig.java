package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._01_injecting_external_values._02_resolving_property_placeholders._03_placeholders_in_java_auto_wiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan
@PropertySource("listing_in_01_03_05_01_02/_03_auto_wiring/prop.properties")
public class SpringConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}