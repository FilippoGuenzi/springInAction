package _01_core_spring._01_springing_into_action._01_simplifying_java_development._03_applying_aspects.listing_01_09_logging_without_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(KnightQuestConfig.class);
        Knight knight = springContext.getBean(Knight.class);
        knight.embarkOnQuest();
        springContext.close();
    }
}
