package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._04_annotating_beans_to_be_automatically_wired.listing_02_06_autowire_example.aside_practice.moving_autowired_annotation_on_fields;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MediaPlayer player = context.getBean(MediaPlayer.class);
        player.play();
        context.close();
    }
}
