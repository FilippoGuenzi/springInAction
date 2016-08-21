package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._02_placeholders_in_java_config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@PropertySource("listing_in_01_03_05_02_01/_02_java_config/prop.properties")
public class SpringConfig {

    @Value("${author}")
    private String author;

    @Value("${title}")
    private String title;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public CompactDisc getCD() {
        return new SpecificCD(author, title);
    }
}
