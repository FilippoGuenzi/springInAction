package _01_core_spring._02_wiring_beans._05_importing_and_mixing_configurations._03_import_java_config_into_xml_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CDLauncher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDConfig.class);
        CompactDisc cd = context.getBean(CompactDisc.class);
        cd.play();
        context.close();
    }

}
