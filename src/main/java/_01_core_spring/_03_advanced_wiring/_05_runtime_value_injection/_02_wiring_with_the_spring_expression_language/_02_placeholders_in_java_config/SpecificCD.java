package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._02_wiring_with_the_spring_expression_language._02_placeholders_in_java_config;

public class SpecificCD implements CompactDisc {
    private String author;
    private String title;

    public SpecificCD(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + author);
    }
}
