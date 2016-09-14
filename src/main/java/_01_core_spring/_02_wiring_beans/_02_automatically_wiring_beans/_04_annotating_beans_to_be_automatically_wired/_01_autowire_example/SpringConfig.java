package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._04_annotating_beans_to_be_automatically_wired._01_autowire_example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackageClasses = {ComponentScanMarker.class}, excludeFilters = {@ComponentScan.Filter(type=FilterType.REGEX, pattern = ".*moving_autowired_annotation_on_fields.*")})
public class SpringConfig {}
