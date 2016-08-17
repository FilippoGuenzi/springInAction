package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._01_designating_a_primary_bean._02_java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DinerConfig {

    @Bean
    public Diner getDiner(Dessert dessert) {
        Diner diner = new Diner();
        diner.setDessert(dessert);
        return diner;
    }

    @Bean
    public Dessert getCake() {
        return new Cake();
    }

    @Primary
    @Bean
    public Dessert getCookies() {
        return new Cookies();
    }

    @Bean
    public Dessert getIceCream() {
        return new IceCream();
    }

}
