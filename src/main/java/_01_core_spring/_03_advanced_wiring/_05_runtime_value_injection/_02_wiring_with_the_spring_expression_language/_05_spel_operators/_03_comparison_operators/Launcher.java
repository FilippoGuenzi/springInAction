package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._03_comparison_operators;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        OtherBean oBean = context.getBean(OtherBean.class);
        System.out.println(oBean.getRandomNumber());
        System.out.println(oBean.isOverAnHalf());
        context.close();
    }
}
