package _02_spring_on_the_web._05_building_spring_web_applications._01_getting_started_with_spring_mvc._02_setting_up_spring_mvc._03_example_app;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { ServletConfig.class };
    }

    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
