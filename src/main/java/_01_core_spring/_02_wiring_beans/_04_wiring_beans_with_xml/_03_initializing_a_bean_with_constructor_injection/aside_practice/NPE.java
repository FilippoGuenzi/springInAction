package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._03_initializing_a_bean_with_constructor_injection.aside_practice;

import java.util.List;

public class NPE {
    private static List<String> strings;

    public static void main(String[] args) {
        for (String s : strings){}
    }
}
