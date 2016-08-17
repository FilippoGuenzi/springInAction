package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._02_qualifying_autowired_beans._01_with_qualifier_annotation._01_default_qualifiers;

import org.springframework.stereotype.Component;

@Component
public class IceCream implements Dessert {

    @Override
    public String toString() {
        return "IceCream";
    }
}
