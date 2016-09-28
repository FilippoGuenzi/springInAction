package _02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(
        basePackages = {"_02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller"},
        excludeFilters = { @ComponentScan.Filter(type = FilterType.REGEX, pattern = "_02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller._01_testing_the_controller.*") }
)
@EnableWebMvc
public class ServletConfig extends WebMvcConfigurerAdapter {

    @Bean
    ViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/views/_02/_05/_02/");
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setExposeContextBeansAsAttributes(true);
        return resourceViewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
