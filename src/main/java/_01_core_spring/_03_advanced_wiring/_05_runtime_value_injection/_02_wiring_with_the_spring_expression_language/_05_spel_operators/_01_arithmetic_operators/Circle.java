package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._01_arithmetic_operators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle {

    private double radius;

    @Autowired
    public Circle(@Value("${radius}") double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
