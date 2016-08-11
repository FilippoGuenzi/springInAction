package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._04_setting_properties._01_CHOOSING_BETWEEN_CONSTRUCTOR_INJECTION_AND_PROPERTY_INJECTION;

public class CompactDisc {
    private String author;
    private String title;

    public CompactDisc(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public void play(){
        System.out.println("playing " + title + " by " + author);
    }
}
