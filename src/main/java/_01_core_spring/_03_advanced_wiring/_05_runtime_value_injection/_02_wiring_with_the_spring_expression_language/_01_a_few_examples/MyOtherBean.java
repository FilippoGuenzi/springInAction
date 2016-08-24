package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._01_a_few_examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyOtherBean {

    private int size;

    @Autowired
    public MyOtherBean(@Value("${myotherbeansize}") int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void showSize() {
        System.out.println(this.size);
    }
}
