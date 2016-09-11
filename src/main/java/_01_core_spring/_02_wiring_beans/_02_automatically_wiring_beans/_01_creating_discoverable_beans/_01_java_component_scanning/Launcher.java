package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._01_creating_discoverable_beans._01_java_component_scanning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        CompactDisc cd = springContext.getBean(CompactDisc.class);
        cd.play();
        springContext.close();
    }
}
