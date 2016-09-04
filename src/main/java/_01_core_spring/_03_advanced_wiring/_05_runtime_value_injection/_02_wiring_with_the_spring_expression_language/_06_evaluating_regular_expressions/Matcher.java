package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._06_evaluating_regular_expressions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Matcher {

    private boolean overAnHalf;

    @Autowired
    public Matcher(@Value("#{stringGenerator.generate() matches 'abs.*d'}") boolean overAnHalf) {
        this.overAnHalf = overAnHalf;
    }

    public boolean isOverAnHalf() {
        return overAnHalf;
    }
}
