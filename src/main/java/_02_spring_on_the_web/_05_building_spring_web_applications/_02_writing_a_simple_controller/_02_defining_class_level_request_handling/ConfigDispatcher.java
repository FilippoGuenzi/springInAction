package _02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller._02_defining_class_level_request_handling;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ConfigDispatcher extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ServletConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[0];
    }
}
