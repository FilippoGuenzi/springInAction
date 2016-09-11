package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._01_creating_discoverable_beans._02_xml_component_scanning;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("_01/_02/_02/_01/sgtPeppersSpringConfig.xml");
        CompactDisc cd = springContext.getBean(CompactDisc.class);
        cd.play();
        springContext.close();
    }
}
