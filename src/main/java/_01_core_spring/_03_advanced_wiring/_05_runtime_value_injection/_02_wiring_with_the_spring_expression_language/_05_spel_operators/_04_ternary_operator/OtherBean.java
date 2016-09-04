package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._04_ternary_operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OtherBean {

    private boolean underAnHalf;
    private double randomNumber;

    @Autowired
    public OtherBean(@Value("#{random.randomNumber >= 0.5 ? false : true}") boolean underAnHalf, @Value("#{random.randomNumber}") double randomNumber) {
        this.underAnHalf = underAnHalf;
        this.randomNumber = randomNumber;
    }

    public boolean isUnderAnHalf() {
        return underAnHalf;
    }

    public double getRandomNumber() {
        return randomNumber;
    }
}
