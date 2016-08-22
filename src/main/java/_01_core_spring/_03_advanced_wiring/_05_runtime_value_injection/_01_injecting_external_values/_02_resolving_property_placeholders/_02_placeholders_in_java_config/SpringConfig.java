package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._01_injecting_external_values._02_resolving_property_placeholders._02_placeholders_in_java_config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@PropertySource("listing_in_01_03_05_01_02/_02_java_config/prop.properties")
public class SpringConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public CompactDisc getCD(@Value("${author}") String author, @Value("${title}") String title) {
        return new SpecificCD(author, title);
    }
}
