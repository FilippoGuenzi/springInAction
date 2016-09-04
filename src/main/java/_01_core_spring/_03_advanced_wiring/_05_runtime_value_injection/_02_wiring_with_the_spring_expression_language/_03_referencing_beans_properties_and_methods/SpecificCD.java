package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._03_referencing_beans_properties_and_methods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpecificCD implements CompactDisc {

    private String author;
    private String title;

    @Autowired
    public SpecificCD(@Value("${disc.author}") String author, @Value("${disc.title}") String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String statement(){
        return "birds are singing in the garden";
    }

    public void play() {
        System.out.println("Playing " + this.title + " by " + this.author);
    }
}
