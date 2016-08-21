package _01_core_spring._03_advanced_wiring._05_runtime_value_injection._01_injecting_external_values._01_example;

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
