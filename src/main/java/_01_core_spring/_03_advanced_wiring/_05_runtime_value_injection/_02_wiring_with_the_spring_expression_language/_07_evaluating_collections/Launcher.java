package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._07_evaluating_collections;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        CompactDisc cd = context.getBean(CompactDisc.class);
        for(Song s : cd.getSongs()) {
            System.out.println(s.getAuthor());
            System.out.println(s.getTitle());
        }
        context.close();
    }
}
