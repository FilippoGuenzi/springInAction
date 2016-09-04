package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._05_elvis_operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TitleGenerator {

    private String title;

    public TitleGenerator() {
        this.title = "Les Schtroumpfs la la";
    }

    public String generate(){
        return Math.random() > 0.5 ? null : title;
    }

    public String getTitle() {
        return title;
    }
}
