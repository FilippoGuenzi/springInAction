package _02_spring_on_the_web._05_building_spring_web_applications._01_getting_started_with_spring_mvc._02_setting_up_spring_mvc._02_enabling_spring_mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(
        basePackages = {"_02_spring_on_the_web._05_building_spring_web_applications._01_getting_started_with_spring_mvc._02_setting_up_spring_mvc._02_enabling_spring_mvc"},
        excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)}
)
public class RootConfig {


}
