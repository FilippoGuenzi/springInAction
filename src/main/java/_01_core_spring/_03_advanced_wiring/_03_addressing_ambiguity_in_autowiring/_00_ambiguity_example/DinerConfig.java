package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._00_ambiguity_example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {ComponentScanMarker.class})
public class DinerConfig {

}
