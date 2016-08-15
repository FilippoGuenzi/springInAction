package _01_core_spring._02_wiring_beans._05_importing_and_mixing_configurations._02_import_xml_config_into_xml_config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("listing_in_01_02_05_02/Player-config.xml");
        CDPlayer player = context.getBean(CDPlayer.class);
        player.play();
        context.close();
    }
}
