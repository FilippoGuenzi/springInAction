package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._02_qualifying_autowired_beans._02_with_custom_qualifiers_annotations.components;

import _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._02_qualifying_autowired_beans._02_with_custom_qualifiers_annotations.qualifiers.Cold;
import _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._02_qualifying_autowired_beans._02_with_custom_qualifiers_annotations.qualifiers.Crispy;
import _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._02_qualifying_autowired_beans._02_with_custom_qualifiers_annotations.qualifiers.Crunchy;
import _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._02_qualifying_autowired_beans._02_with_custom_qualifiers_annotations.qualifiers.Sweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Diner {

    private Dessert dessert;

    @Sweet
    @Crispy
    @Autowired
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public void describeDessert() {
        System.out.println("Dessert is " + dessert);
    }
}
