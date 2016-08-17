package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._01_designating_a_primary_bean._04_two_primary_beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DinerConfig.class);
        Diner diner = context.getBean(Diner.class);
        diner.describeDessert();
        context.close();
    }
}
