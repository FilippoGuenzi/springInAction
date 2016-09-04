package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._05_elvis_operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CompactDisc {

    private String title;

    @Autowired
    public CompactDisc(@Value("#{titleGenerator.generate()}") String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
