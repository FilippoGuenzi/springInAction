package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._01_designating_a_primary_bean._04_two_primary_beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Cookies implements Dessert {

    @Override
    public String toString() {
        return "Cookies";
    }
}
