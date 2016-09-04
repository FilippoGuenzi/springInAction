package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._03_comparison_operators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OtherBean {

    private boolean overAnHalf;
    private double randomNumber;

    @Autowired
    public OtherBean(@Value("#{random.randomNumber > 0.5}") boolean overAnHalf, @Value("#{random.randomNumber}") double randomNumber) {
        this.overAnHalf = overAnHalf;
        this.randomNumber = randomNumber;
    }

    public boolean isOverAnHalf() {
        return overAnHalf;
    }

    public double getRandomNumber() {
        return randomNumber;
    }
}
