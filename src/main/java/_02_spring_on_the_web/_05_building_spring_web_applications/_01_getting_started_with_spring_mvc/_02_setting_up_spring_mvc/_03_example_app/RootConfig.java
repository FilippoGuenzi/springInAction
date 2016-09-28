package _02_spring_on_the_web._05_building_spring_web_applications._01_getting_started_with_spring_mvc._02_setting_up_spring_mvc._03_example_app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(basePackages = {"_02_spring_on_the_web._05_building_spring_web_applications._01_getting_started_with_spring_mvc._02_setting_up_spring_mvc._03_example_app"})
public class RootConfig {
}
