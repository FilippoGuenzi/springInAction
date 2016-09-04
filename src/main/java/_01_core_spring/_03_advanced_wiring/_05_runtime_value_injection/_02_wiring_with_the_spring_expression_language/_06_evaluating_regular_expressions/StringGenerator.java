package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._06_evaluating_regular_expressions;

import org.springframework.stereotype.Component;

@Component
public class StringGenerator {

    public String generate(){
        return java.lang.Math.random() > 0.5 ? "abscond" : "marmelade";
    }
}
