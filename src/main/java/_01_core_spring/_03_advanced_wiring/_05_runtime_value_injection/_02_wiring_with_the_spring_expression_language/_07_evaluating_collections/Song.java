package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._07_evaluating_collections;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import static java.lang.Math.*;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Song {

    private String author;
    private String title;

    public Song() {
        this.author = "author " + floor(random() * 10);
        this.title = "title " + + floor(random() * 10) + " of " + author;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
