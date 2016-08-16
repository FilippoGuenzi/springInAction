package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._00_ambiguity_example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DinerConfig.class);
        Diner diner = context.getBean(Diner.class);
        context.close();
    }
}
