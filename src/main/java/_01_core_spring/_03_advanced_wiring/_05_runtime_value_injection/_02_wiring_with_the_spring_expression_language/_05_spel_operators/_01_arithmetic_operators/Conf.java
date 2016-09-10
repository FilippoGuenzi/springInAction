package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._01_arithmetic_operators;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan
@PropertySource("listings/_01/_03/_05/_02/_05/prop.properties")
public class Conf {

    @Bean
    public static PropertySourcesPlaceholderConfigurer getProperties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
