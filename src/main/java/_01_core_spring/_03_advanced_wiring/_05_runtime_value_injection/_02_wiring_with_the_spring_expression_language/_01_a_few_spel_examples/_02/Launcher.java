package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._01_a_few_spel_examples._02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CompactDisc cd = context.getBean(CompactDisc.class);
        cd.play();
        context.close();
    }
}
