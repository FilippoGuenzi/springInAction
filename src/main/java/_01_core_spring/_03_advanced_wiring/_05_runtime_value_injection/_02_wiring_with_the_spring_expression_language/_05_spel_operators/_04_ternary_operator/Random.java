package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._04_ternary_operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Random {
    private double randomNumber;

    @Autowired
    public Random(@Value("#{T(java.lang.Math).random()}") double randomNumber) {
        this.randomNumber = randomNumber;
    }

    public double getRandomNumber() {
        return randomNumber;
    }
}
