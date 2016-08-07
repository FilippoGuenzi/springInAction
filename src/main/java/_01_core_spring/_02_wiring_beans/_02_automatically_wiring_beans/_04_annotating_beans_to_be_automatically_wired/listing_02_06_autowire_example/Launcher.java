package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._04_annotating_beans_to_be_automatically_wired.listing_02_06_autowire_example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        MediaPlayer mediaPlayer = springContext.getBean(MediaPlayer.class);
        mediaPlayer.play();
        springContext.close();
    }
}
