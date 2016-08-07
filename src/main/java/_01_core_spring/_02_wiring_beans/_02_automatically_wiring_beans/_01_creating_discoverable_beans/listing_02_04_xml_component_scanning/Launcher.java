package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._01_creating_discoverable_beans.listing_02_04_xml_component_scanning;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("listing_02_02_xml_component_scanning/sgtPeppersSpringConfig.xml");
        CompactDisc cd = springContext.getBean(CompactDisc.class);
        cd.play();
        springContext.close();
    }
}
