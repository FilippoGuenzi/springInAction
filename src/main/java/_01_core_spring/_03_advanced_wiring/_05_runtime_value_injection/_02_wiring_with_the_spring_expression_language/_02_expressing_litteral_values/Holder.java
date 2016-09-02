package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._02_expressing_litteral_values;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Holder {

    private String string;
    private double aDouble;
    private float aFloat;
    private boolean aBoolean;

    @Autowired
    public Holder(@Value("#{true}") boolean aBoolean, @Value("#{2.1E7}") double aDouble, @Value("#{3.1415926}") float aFloat, @Value("Coucou") String string) {
        this.aBoolean = aBoolean;
        this.aDouble = aDouble;
        this.aFloat = aFloat;
        this.string = string;
    }

    public void show(){
        System.out.println("here is my content : " + "\n -" + aBoolean + "\n -" + aDouble + "\n -" + aFloat + "\n -" + string);
    }
}
