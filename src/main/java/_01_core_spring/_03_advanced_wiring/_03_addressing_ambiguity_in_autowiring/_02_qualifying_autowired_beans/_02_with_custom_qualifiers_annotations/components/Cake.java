package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._02_qualifying_autowired_beans._02_with_custom_qualifiers_annotations.components;

import _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._02_qualifying_autowired_beans._02_with_custom_qualifiers_annotations.qualifiers.Crunchy;
import _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._02_qualifying_autowired_beans._02_with_custom_qualifiers_annotations.qualifiers.Sweet;
import org.springframework.stereotype.Component;

@Sweet
@Crunchy
@Component
public class Cake implements Dessert {

    @Override
    public String toString() {
        return "Cake";
    }
}
