package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._01_a_few_spel_examples._03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("listing_in_01_03_05_02_01/_03/springConf.xml");
        CompactDisc cd = context.getBean(CompactDisc.class);
        cd.play();
        context.close();
    }
}
