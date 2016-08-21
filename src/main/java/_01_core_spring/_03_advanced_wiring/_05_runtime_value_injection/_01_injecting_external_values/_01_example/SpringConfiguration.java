package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._01_injecting_external_values._01_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("listing_in_01_03_05_01/prop.properties")
public class SpringConfiguration {

    @Autowired
    Environment environment;

    @Bean
    public CompactDisc getCD() {
        String author = environment.getProperty("author");
        String title = environment.getProperty("title");
        return new SpecificCD(author, title);
    }
}
