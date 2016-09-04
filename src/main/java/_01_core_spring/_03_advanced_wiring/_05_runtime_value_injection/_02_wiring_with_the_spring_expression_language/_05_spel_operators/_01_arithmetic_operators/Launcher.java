package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._01_arithmetic_operators;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        CircleCalculator calc = context.getBean(CircleCalculator.class);
        System.out.println(calc.getRadius());
        System.out.println(calc.getCirconference());
        System.out.println(calc.getArea());
    }
}
