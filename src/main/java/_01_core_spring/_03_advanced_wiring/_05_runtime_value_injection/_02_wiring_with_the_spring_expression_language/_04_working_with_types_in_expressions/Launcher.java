package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._04_working_with_types_in_expressions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        Math math = context.getBean(Math.class);
        System.out.println(math.getF());
        Class<java.lang.Math> mathClass = math.getMathClass();
        System.out.println(mathClass.getCanonicalName());
        System.out.println(math.getPi());
    }
}
