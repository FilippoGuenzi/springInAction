package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._04_setting_properties._01_CHOOSING_BETWEEN_CONSTRUCTOR_INJECTION_AND_PROPERTY_INJECTION;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("listing_in_01_02_04_04_01/springConf.xml");
        CDPlayer cdPlayer = springContext.getBean(CDPlayer.class);
        cdPlayer.play();
        springContext.close();
    }
}
