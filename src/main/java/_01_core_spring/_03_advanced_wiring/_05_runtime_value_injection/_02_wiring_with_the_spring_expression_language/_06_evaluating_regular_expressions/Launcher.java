package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._06_evaluating_regular_expressions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        Matcher m = context.getBean(Matcher.class);
        System.out.println(m.isOverAnHalf());
        context.close();
    }
}
