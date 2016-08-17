package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._01_designating_a_primary_bean._03_xml_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("listing_in_01_03_03_01_03/configuration.xml");
        Diner diner = context.getBean(Diner.class);
        diner.describeDessert();
        context.close();
    }
}
