package _01_core_spring._02_wiring_beans._04_wiring_beans_with_xml._04_setting_properties._01_CHOOSING_BETWEEN_CONSTRUCTOR_INJECTION_AND_PROPERTY_INJECTION;

public class CDPlayer {
    private CompactDisc cd;

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void play(){
        if(cd != null){
            cd.play();
        }

    }
}
