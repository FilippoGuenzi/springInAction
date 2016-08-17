package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._01_designating_a_primary_bean._01_java_component_scanning;

import org.springframework.stereotype.Component;

@Component
public class Cake implements Dessert {

    @Override
    public String toString() {
        return "Cake";
    }
}
