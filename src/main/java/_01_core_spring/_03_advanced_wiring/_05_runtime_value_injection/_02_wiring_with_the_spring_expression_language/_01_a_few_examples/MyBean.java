package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._01_a_few_examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private String value;

    @Autowired
    public MyBean(@Value("#{1}") String value) {
        this.value = value;
    }

    public void showValue(){
        System.out.println(value);
    }
}
