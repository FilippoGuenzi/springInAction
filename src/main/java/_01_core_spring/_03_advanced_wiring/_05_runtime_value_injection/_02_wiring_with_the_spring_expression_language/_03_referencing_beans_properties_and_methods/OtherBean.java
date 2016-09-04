package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._03_referencing_beans_properties_and_methods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OtherBean {

    private String specificCDArtist;
    private SpecificCD cd;
    private String statement;

    @Autowired
    public OtherBean(@Value("#{specificCD.author}") String specificCDArtist, @Value("#{specificCD}") SpecificCD cd, @Value("#{specificCD.statement()?.toUpperCase()}") String statement) {
        this.specificCDArtist = specificCDArtist;
        this.cd = cd;
        this.statement = statement;
    }

    public void method() {
        System.out.println(specificCDArtist);
        System.out.println(cd.getAuthor());
        cd.play();
        System.out.println(this.statement);
    }
}
