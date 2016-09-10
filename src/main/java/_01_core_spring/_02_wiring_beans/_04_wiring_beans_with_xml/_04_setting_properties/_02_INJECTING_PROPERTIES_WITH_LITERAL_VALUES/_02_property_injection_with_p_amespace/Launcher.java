package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._04_setting_properties._02_INJECTING_PROPERTIES_WITH_LITERAL_VALUES._02_property_injection_with_p_amespace;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("listings/_01/_02/_04/_04/_02/_02/springConfig.xml");
        BlankDisc disc = context.getBean(BlankDisc.class);
        disc.play();
        context.close();
    }
}
