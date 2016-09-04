package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._02_concatenation;

import org.springframework.stereotype.Component;

@Component
public class CompactDisc {
    private String author;
    private String title;

    public CompactDisc() {
        this.author = "The Beatles";
        this.title = "Yellow Submarine";
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
