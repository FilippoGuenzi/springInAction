package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._03_initializing_a_bean_with_constructor_injection._02_WITH_LITERAL_VALUES;

public class BlankDisc {

    private String author;
    private String title;

    public BlankDisc(String author, String title) {
        this.author = author;
        this.title = title;
    }
}
