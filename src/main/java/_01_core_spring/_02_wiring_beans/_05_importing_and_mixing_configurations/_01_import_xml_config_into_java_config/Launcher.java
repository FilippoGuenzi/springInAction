package _01_core_spring._02_wiring_beans._05_importing_and_mixing_configurations._01_import_xml_config_into_java_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PlayerSpringConfig.class);
        CDPlayer player = context.getBean(CDPlayer.class);
        player.play();
        context.close();
    }
}
