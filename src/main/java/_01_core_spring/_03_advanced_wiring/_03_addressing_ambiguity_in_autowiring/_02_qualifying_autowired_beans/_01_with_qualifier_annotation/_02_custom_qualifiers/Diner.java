package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._02_qualifying_autowired_beans._01_with_qualifier_annotation._02_custom_qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Diner {

    private Dessert dessert;

    @Qualifier("crispy")
    @Autowired
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public void describeDessert() {
        System.out.println("Dessert is " + dessert);
    }
}
