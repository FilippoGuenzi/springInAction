package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._03_initializing_a_bean_with_constructor_injection._03_WIRING_COLLECTIONS;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LanceurWithFilledList {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("listings/_01/_02/_04/_03/_03/springConfigurationWithFilledList.xml");
        CompactDisc cd = context.getBean(CompactDisc.class);
        cd.play();
        context.close();
    }
}
