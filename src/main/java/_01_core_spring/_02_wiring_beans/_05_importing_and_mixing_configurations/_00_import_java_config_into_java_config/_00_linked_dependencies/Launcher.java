package _01_core_spring._02_wiring_beans._05_importing_and_mixing_configurations._00_import_java_config_into_java_config._00_linked_dependencies;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PlayerSpringConfig.class);
        CDPlayer player = context.getBean(CDPlayer.class);
        player.play();
        context.close();
    }
}
