package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies._06_starting_a_spring_context._01_with_java_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(KnightAppConfig.class);
        Knight knight = springContext.getBean(Knight.class);
        knight.embarkOnQuest();
        springContext.close();
    }
}
