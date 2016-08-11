package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._03_initializing_a_bean_with_constructor_injection._03_WIRING_COLLECTIONS;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanceur {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("listing_in_01_02_04_03_03/springConfiguration.xml");
        Discography allCDs = context.getBean(Discography.class);
        allCDs.play();
        context.close();
    }
}
