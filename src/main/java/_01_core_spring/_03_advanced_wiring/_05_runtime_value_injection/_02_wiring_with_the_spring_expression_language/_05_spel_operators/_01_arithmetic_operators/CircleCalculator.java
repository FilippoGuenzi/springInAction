package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._01_arithmetic_operators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CircleCalculator {
    private double radius;
    private double circonference;
    private double area;

    @Autowired
    public CircleCalculator(
            @Value("#{circle.radius}") double radius,
            @Value("#{2 * T(java.lang.Math).PI * circle.radius}") double circonference,
            @Value("#{T(java.lang.Math).PI * circle.radius^2}") double area
                           ) {
        this.radius = radius;
        this.circonference = circonference;
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public double getCirconference() {
        return circonference;
    }

    public double getRadius() {
        return radius;
    }
}
