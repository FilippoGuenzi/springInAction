package _01_core_spring._03_advanced_wiring._02_conditional_beans.listing_01_03_04_conditionally_configuring_beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MagicBeanConfig.class);
        MagicBean magicBean = context.getBean(MagicBean.class);
        magicBean.iExist();
        context.close();
    }


}
