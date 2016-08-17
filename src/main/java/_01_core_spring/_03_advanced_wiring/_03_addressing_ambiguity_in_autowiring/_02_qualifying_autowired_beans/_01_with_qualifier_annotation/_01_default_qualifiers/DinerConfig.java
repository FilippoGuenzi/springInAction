package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._02_qualifying_autowired_beans._01_with_qualifier_annotation._01_default_qualifiers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {ComponentScanMarker.class})
public class DinerConfig {

}
