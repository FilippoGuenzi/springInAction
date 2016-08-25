package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._01_a_few_examples;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        MyBean myBean = context.getBean(MyBean.class);
        myBean.showValue();
        myBean.showMillis();
        myBean.showMyOtherBeanSize();
        myBean.readProperty();
        context.close();
    }
}
