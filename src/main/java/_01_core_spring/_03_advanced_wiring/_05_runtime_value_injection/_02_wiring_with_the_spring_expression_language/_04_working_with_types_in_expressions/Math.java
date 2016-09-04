package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._04_working_with_types_in_expressions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Math {
    private double pi;
    private Class mathClass;
    private float f;

    @Autowired
    public Math(@Value("#{T(java.lang.Math)}") Class mathClass, @Value("#{T(java.lang.Math).PI}") double pi, @Value("#{T(java.lang.Math).random()}") float f ) {
        this.pi = pi;
        this.mathClass = mathClass;
        this.f = f;
    }

    public float getF() {
        return f;
    }

    public Class getMathClass() {
        return mathClass;
    }

    public double getPi() {
        return pi;
    }
}
