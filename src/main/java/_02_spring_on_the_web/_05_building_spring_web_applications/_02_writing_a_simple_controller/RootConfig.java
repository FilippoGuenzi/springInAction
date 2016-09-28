package _02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        basePackages = {"_02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller"},
        excludeFilters = { @Filter(type = FilterType.REGEX, pattern = "_02_spring_on_the_web._05_building_spring_web_applications._02_writing_a_simple_controller._01_testing_the_controller.*") }
)
public class RootConfig {
}
