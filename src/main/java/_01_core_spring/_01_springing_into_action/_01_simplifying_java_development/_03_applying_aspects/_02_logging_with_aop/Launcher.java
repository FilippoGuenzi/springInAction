package _01_core_spring._01_springing_into_action._01_simplifying_java_development._03_applying_aspects._02_logging_with_aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("_01/_03/minstrelSingingQuest.xml");
        Knight knight = springContext.getBean(Knight.class);
        knight.embarkOnQuest();
        springContext.close();
    }
}
