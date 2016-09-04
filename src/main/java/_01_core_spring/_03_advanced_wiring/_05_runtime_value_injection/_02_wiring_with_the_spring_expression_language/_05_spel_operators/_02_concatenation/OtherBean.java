package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._05_spel_operators._02_concatenation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OtherBean {

    private String playingStatement;

    @Autowired
    public OtherBean(@Value("#{'playing ' + compactDisc.title + ' by ' + compactDisc.author}") String playingStatement) {
        this.playingStatement = playingStatement;
    }

    public String getPlayingStatement() {
        return playingStatement;
    }
}
