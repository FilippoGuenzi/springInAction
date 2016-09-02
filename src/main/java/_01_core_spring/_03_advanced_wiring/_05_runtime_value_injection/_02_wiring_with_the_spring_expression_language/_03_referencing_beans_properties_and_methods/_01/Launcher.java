package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._03_referencing_beans_properties_and_methods._01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MediaPlayer mp = context.getBean(MediaPlayer.class);
        mp.play();
        context.close();
    }
}
