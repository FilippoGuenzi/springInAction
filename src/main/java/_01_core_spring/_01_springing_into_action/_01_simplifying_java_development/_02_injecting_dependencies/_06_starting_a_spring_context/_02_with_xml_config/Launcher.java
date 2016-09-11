package _01_core_spring._01_springing_into_action._01_simplifying_java_development._02_injecting_dependencies._06_starting_a_spring_context._02_with_xml_config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("_01/_01/_01/_02/_06/_02/knightsConfig.xml");
        Knight knight = springContext.getBean(Knight.class);
        knight.embarkOnQuest();
        springContext.close();
    }
}
