package _02_spring_on_the_web._05_building_spring_web_applications._01_getting_started_with_spring_mvc._02_setting_up_spring_mvc._02_enabling_spring_mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
// enables spring MVC
@EnableWebMvc
@ComponentScan(basePackages = {"_02_spring_on_the_web._05_building_spring_web_applications._01_getting_started_with_spring_mvc._02_setting_up_spring_mvc._02_enabling_spring_mvc"})
public class ServletConfig extends WebMvcConfigurerAdapter {

    // configure a JSP view resolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    // the handling of static resources will be forwarded by DispatcherServlet to servlet container default Servlet.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
