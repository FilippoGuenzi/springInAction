package _01_core_spring._02_wiring_beans._02_automatically_wiring_beans._05_verifying_automatic_configuration._01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {PackageToScanMarker.class })
public class SpringConfig {}
