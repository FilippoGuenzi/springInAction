package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._01_designating_a_primary_bean._03_xml_config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("listings/_01/_03/_03/_01/_03/configuration.xml");
        Diner diner = context.getBean(Diner.class);
        diner.describeDessert();
        context.close();
    }
}
