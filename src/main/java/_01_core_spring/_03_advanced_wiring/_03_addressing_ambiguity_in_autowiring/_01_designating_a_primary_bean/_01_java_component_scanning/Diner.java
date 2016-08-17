package _01_core_spring._03_advanced_wiring._03_addressing_ambiguity_in_autowiring._01_designating_a_primary_bean._01_java_component_scanning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Diner {

    private Dessert dessert;

    @Autowired
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public void describeDessert() {
        System.out.println("Dessert is " + dessert);
    }
}
