package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._01_injecting_external_values._00_example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        CompactDisc cd = context.getBean(CompactDisc.class);
        cd.play();
        context.close();
    }
}
