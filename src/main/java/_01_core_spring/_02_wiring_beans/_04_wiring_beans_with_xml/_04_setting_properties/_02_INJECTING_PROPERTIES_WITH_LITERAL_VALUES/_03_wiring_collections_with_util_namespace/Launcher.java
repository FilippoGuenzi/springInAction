package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._04_setting_properties._02_INJECTING_PROPERTIES_WITH_LITERAL_VALUES._03_wiring_collections_with_util_namespace;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_01/_02/_04/_04/_02/_03/springConfig.xml");
        BlankDisc disc = context.getBean(BlankDisc.class);
        disc.play();
        context.close();
    }
}
